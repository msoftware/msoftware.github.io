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
import android.os.Build;
import android.support.test.jank.JankTestBase;
import android.support.test.jank.WindowAnimationFrameStatsMonitor;
import android.support.test.jank.WindowContentFrameStatsMonitor;
import android.support.test.jank.GfxMonitor;
import android.util.Log;

import junit.framework.Assert;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/** @hide */
public class JankMonitorFactory {

    private static String TAG = "JankTestHelper";

    static final int API_LEVEL_ACTUAL = Build.VERSION.SDK_INT
            + ("REL".equals(Build.VERSION.CODENAME) ? 0 : 1);

    private UiAutomation mUiAutomation;

    public JankMonitorFactory(UiAutomation automation) {
        mUiAutomation = automation;
    }

    public List<JankMonitor> getJankMonitors(Method testMethod, JankTestBase testInstance) {
        List<JankMonitor> monitors = new ArrayList<JankMonitor>();
        if (testMethod.getAnnotation(GfxMonitor.class) != null) {
            // GfxMonitor only works on M+. NB: Hard coding value since SDK 22 isn't in prebuilts.
            if (API_LEVEL_ACTUAL <= 22) {
                Log.w(TAG, "Skipping GfxMonitor. Not supported by current platform.");
            } else {
                String process = testMethod.getAnnotation(GfxMonitor.class).processName();
                // if process name starts with "#", treat it as a method that returns process name
                if (process.startsWith("#")) {
                    process = process.substring(1);
                    Method method = null;
                    try {
                        method = testMethod.getDeclaringClass().getMethod(process, (Class[]) null);
                    } catch (NoSuchMethodException e) {
                        Assert.fail(String.format("Method \"%s\" not found", process));
                    }

                    if (!Modifier.isPublic(method.getModifiers())) {
                        Assert.fail(String.format("Method \"%s\" should be public", process));
                    }

                    Object o = null;
                    try {
                        o = method.invoke(testInstance, (Object[])null);
                    } catch (IllegalAccessException | IllegalArgumentException
                            | InvocationTargetException e) {
                        Assert.fail(String.format(
                                "Exception %s(%s) while invoking \"%s\" for monitored process name",
                                e.getClass().getName(), e.getMessage(), process));
                    }
                    if (o == null || !(o instanceof String)) {
                        Assert.fail(String.format("Method \"%s\" should return String", process));
                    }
                    process = (String)o;
                    Log.d(TAG, "Using process name from annotated method: " + process);
                }
                monitors.add(new GfxMonitorImpl(mUiAutomation, process));
            }
        }
        if (testMethod.getAnnotation(WindowContentFrameStatsMonitor.class) != null) {
            monitors.add(new WindowContentFrameStatsMonitorImpl(mUiAutomation));
        }
        if (testMethod.getAnnotation(WindowAnimationFrameStatsMonitor.class) != null) {
            monitors.add(new WindowAnimationFrameStatsMonitorImpl(mUiAutomation));
        }
        return monitors;
    }
}
