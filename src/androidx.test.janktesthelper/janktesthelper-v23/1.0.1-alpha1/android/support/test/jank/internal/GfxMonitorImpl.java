/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.support.test.jank.internal;

import android.app.UiAutomation;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.support.test.jank.GfxMonitor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import junit.framework.Assert;

/**
 * Monitors dumpsys gfxinfo to detect janky frames.
 *
 * Reports average and max jank. Additionally reports summary statistics for common problems that
 * can lead to dropped frames.
 */
class GfxMonitorImpl implements JankMonitor {

    // Patterns used for parsing dumpsys gfxinfo output
    public enum JankStat {
        TOTAL_FRAMES(Pattern.compile("\\s*Total frames rendered: (\\d+)"), 1, Integer.class),
        NUM_JANKY(Pattern.compile("\\s*Janky frames: (\\d+) \\((\\d+(\\.\\d+))%\\)"), 2,
                Double.class),
        FRAME_TIME_90TH(Pattern.compile("\\s*90th percentile: (\\d+)ms"), 1, Integer.class),
        FRAME_TIME_95TH(Pattern.compile("\\s*95th percentile: (\\d+)ms"), 1, Integer.class),
        FRAME_TIME_99TH(Pattern.compile("\\s*99th percentile: (\\d+)ms"), 1, Integer.class),
        NUM_MISSED_VSYNC(Pattern.compile("\\s*Number Missed Vsync: (\\d+)"), 1, Integer.class),
        NUM_HIGH_INPUT_LATENCY(Pattern.compile("\\s*Number High input latency: (\\d+)"), 1,
                Integer.class),
        NUM_SLOW_UI_THREAD(Pattern.compile("\\s*Number Slow UI thread: (\\d+)"), 1, Integer.class),
        NUM_SLOW_BITMAP_UPLOADS(Pattern.compile("\\s*Number Slow bitmap uploads: (\\d+)"), 1,
                Integer.class),
        NUM_SLOW_DRAW(Pattern.compile("\\s*Number Slow issue draw commands: (\\d+)"), 1, Integer.class);

        private boolean mSuccessfulParse = false;
        private Pattern mParsePattern;
        private int mGroupIndex;
        private Class mType;

        JankStat(Pattern pattern, int groupIndex, Class type) {
            mParsePattern = pattern;
            mGroupIndex = groupIndex;
            mType = type;
        }

        String parse(String line) {
            String ret = null;
            Matcher matcher = mParsePattern.matcher(line);
            if (matcher.matches()) {
                ret = matcher.group(mGroupIndex);
                mSuccessfulParse = true;
            }
            return ret;
        }

        boolean wasParsedSuccessfully() {
            return mSuccessfulParse;
        }

        void reset() {
            mSuccessfulParse = false;
        }

        Class getType() {
            return mType;
        }
    }

    // Metrics accumulated for each iteration
    private Map<JankStat, List<? extends Number>> mAccumulatedStats =
            new EnumMap<JankStat, List<? extends Number>>(JankStat.class);


    // Used to invoke dumpsys gfxinfo
    private UiAutomation mUiAutomation;
    private String mProcess;


    public GfxMonitorImpl(UiAutomation automation, String process) {
        mUiAutomation = automation;
        mProcess = process;

        for (JankStat stat : JankStat.values()) {
            if (stat.getType().equals(Integer.class)) {
                mAccumulatedStats.put(stat, new ArrayList<Integer>());
            } else if (stat.getType().equals(Double.class)) {
                mAccumulatedStats.put(stat, new ArrayList<Double>());
            } else {
                // Shouldn't get here
                throw new IllegalStateException("Unsupported JankStat type");
            }
        }
    }

    @Override
    public void startIteration() throws IOException {
        // Clear out any previous data
        ParcelFileDescriptor stdout = mUiAutomation.executeShellCommand(
                String.format("dumpsys gfxinfo %s reset", mProcess));

        // Read the output, but don't do anything with it
        BufferedReader stream = new BufferedReader(new InputStreamReader(
                new ParcelFileDescriptor.AutoCloseInputStream(stdout)));
        while (stream.readLine() != null) {
        }
    }


    @Override
    public int stopIteration() throws IOException {
        ParcelFileDescriptor stdout = mUiAutomation.executeShellCommand(
                String.format("dumpsys gfxinfo %s", mProcess));
        BufferedReader stream = new BufferedReader(new InputStreamReader(
                new ParcelFileDescriptor.AutoCloseInputStream(stdout)));

        // The frame stats section has the following output:
        // Total frames rendered: ###
        // Janky frames: ### (##.##%)
        // 90th percentile: ##ms
        // 95th percentile: ##ms
        // 99th percentile: ##ms
        // Number Missed Vsync: #
        // Number High input latency: #
        // Number Slow UI thread: #
        // Number Slow bitmap uploads: #
        // Number Slow draw: #

        String line;
        while ((line = stream.readLine()) != null) {

            // Attempt to parse the line as a frame stat value
            for (JankStat stat : JankStat.values()) {
                String part;
                if ((part = stat.parse(line)) != null) {
                    // Parse was successful. Add the numeric value to the accumulated list of values
                    // for that stat.
                    if (stat.getType().equals(Integer.class)) {
                        List<Integer> stats = (List<Integer>)mAccumulatedStats.get(stat);
                        stats.add(Integer.valueOf(part));
                    } else if (stat.getType().equals(Double.class)) {
                        List<Double> stats = (List<Double>)mAccumulatedStats.get(stat);
                        stats.add(Double.valueOf(part));
                    } else {
                        // Shouldn't get here
                        throw new IllegalStateException("Unsupported JankStat type");
                    }
                    break;
                }
            }
        }

        // Make sure we found all the stats
        for (JankStat stat : JankStat.values()) {
            if (!stat.wasParsedSuccessfully()) {
                Assert.fail(String.format("Failed to parse %s", stat.name()));
            }
            stat.reset();
        }

        List<Integer> totalFrames = (List<Integer>)mAccumulatedStats.get(JankStat.TOTAL_FRAMES);
        return totalFrames.get(totalFrames.size()-1);
    }

    private void putAvgMaxInteger(Bundle metrics, String averageKey, String maxKey,
            List<Integer> values) {

        metrics.putDouble(averageKey, MetricsHelper.computeAverageInt(values));
        metrics.putInt(maxKey, Collections.max(values));
    }

    private void putAvgMaxDouble(Bundle metrics, String averageKey, String maxKey,
            List<Double> values) {

        metrics.putDouble(averageKey, MetricsHelper.computeAverageFloat(values));
        metrics.putDouble(maxKey, Collections.max(values));
    }

    private List<Double> transformToPercentage(List<Integer> values, List<Integer> totals) {
        List<Double> ret = new ArrayList<Double>(values.size());

        Iterator<Integer> valuesItr = values.iterator();
        Iterator<Integer> totalsItr = totals.iterator();
        while (valuesItr.hasNext()) {
            double value = (double)valuesItr.next().intValue();
            double total = (double)totalsItr.next().intValue();

            ret.add(value / total * 100.0f);
        }

        return ret;
    }

    public Bundle getMetrics() {
        Bundle metrics = new Bundle();

        // Retrieve the total number of frames
        List<Integer> totals = (List<Integer>)mAccumulatedStats.get(JankStat.TOTAL_FRAMES);

        // Store average and max jank
        putAvgMaxDouble(metrics, GfxMonitor.KEY_AVG_NUM_JANKY, GfxMonitor.KEY_MAX_NUM_JANKY,
                (List<Double>)mAccumulatedStats.get(JankStat.NUM_JANKY));

        // Store average and max percentile frame times
        putAvgMaxInteger(metrics, GfxMonitor.KEY_AVG_FRAME_TIME_90TH_PERCENTILE,
                GfxMonitor.KEY_MAX_FRAME_TIME_90TH_PERCENTILE,
                (List<Integer>)mAccumulatedStats.get(JankStat.FRAME_TIME_90TH));
        putAvgMaxInteger(metrics, GfxMonitor.KEY_AVG_FRAME_TIME_95TH_PERCENTILE,
                GfxMonitor.KEY_MAX_FRAME_TIME_95TH_PERCENTILE,
                (List<Integer>)mAccumulatedStats.get(JankStat.FRAME_TIME_95TH));
        putAvgMaxInteger(metrics, GfxMonitor.KEY_AVG_FRAME_TIME_99TH_PERCENTILE,
                GfxMonitor.KEY_MAX_FRAME_TIME_99TH_PERCENTILE,
                (List<Integer>)mAccumulatedStats.get(JankStat.FRAME_TIME_99TH));

        // Store average and max missed vsync
        List<Double> missedVsyncPercent = transformToPercentage(
                (List<Integer>)mAccumulatedStats.get(JankStat.NUM_MISSED_VSYNC), totals);
        putAvgMaxDouble(metrics, GfxMonitor.KEY_AVG_MISSED_VSYNC, GfxMonitor.KEY_MAX_MISSED_VSYNC,
                missedVsyncPercent);

        // Store average and max high input latency
        List<Double> highInputLatencyPercent = transformToPercentage(
                (List<Integer>)mAccumulatedStats.get(JankStat.NUM_HIGH_INPUT_LATENCY), totals);
        putAvgMaxDouble(metrics, GfxMonitor.KEY_AVG_HIGH_INPUT_LATENCY,
                GfxMonitor.KEY_MAX_HIGH_INPUT_LATENCY, highInputLatencyPercent);

        // Store average and max slow ui thread
        List<Double> slowUiThreadPercent = transformToPercentage(
                (List<Integer>)mAccumulatedStats.get(JankStat.NUM_SLOW_UI_THREAD), totals);
        putAvgMaxDouble(metrics, GfxMonitor.KEY_AVG_SLOW_UI_THREAD,
                GfxMonitor.KEY_MAX_SLOW_UI_THREAD, slowUiThreadPercent);

        // Store average and max slow bitmap uploads
        List<Double> slowBitMapUploadsPercent = transformToPercentage(
                (List<Integer>)mAccumulatedStats.get(JankStat.NUM_SLOW_BITMAP_UPLOADS), totals);
        putAvgMaxDouble(metrics, GfxMonitor.KEY_AVG_SLOW_BITMAP_UPLOADS,
                GfxMonitor.KEY_MAX_SLOW_BITMAP_UPLOADS, slowBitMapUploadsPercent);

        // Store average and max slow draw
        List<Double> slowDrawPercent = transformToPercentage(
                (List<Integer>)mAccumulatedStats.get(JankStat.NUM_SLOW_DRAW), totals);
        putAvgMaxDouble(metrics, GfxMonitor.KEY_AVG_SLOW_DRAW, GfxMonitor.KEY_MAX_SLOW_DRAW,
                slowDrawPercent);

        return metrics;
    }

    private String getMatchGroup(String input, Pattern pattern, int groupIndex) {
        String ret = null;
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            ret = matcher.group(groupIndex);
        }
        return ret;
    }
}
