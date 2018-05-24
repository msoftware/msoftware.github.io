/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package androidx.test.internal.util;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/** Util class to help extract and manipulate Android processes */
public final class ProcessUtil {
  private static final String TAG = "ProcessUtil";

  private static final List<Integer> RETRY_WAIT_INTERVALS =
      Collections.unmodifiableList(Arrays.asList(8, 8, 16, 32, 64, 128, 256));

  private static String processName;

  /**
   * Helper method to get the name of the process this instance is running in.
   *
   * @param context the context this process is running in.
   * @return returns the current process name or an empty sting if one cannot be found.
   */
  public static String getCurrentProcessName(Context context) {
    if (!TextUtils.isEmpty(processName)) {
      return processName;
    }

    try {
      processName = getCurrentProcessNameUsingActivityManager(context);
    } catch (SecurityException isIsolatedProcess) {
      Log.i(TAG, "Could not read process name from ActivityManager (isolatedProcess?)");
      // processName is uninitialized at this point, and the proc-based fallback will fail, since
      // we're in an isolated process and are forbidden from accessing the filesystem.
      // Terminate early with an empty process name.
      return "";
    }

    if (processName.isEmpty()) {
      Log.w(
          TAG,
          "Could not figure out process name using ActivityManager, falling back to use /proc. "
              + "Note that processName fetched from /proc may be truncated!");
      processName = getCurrentProcessNameUsingProc();
      if (processName.isEmpty()) {
        Log.w(TAG, "Could not figure out process name /proc either");
      }
    }
    return processName;
  }

  /**
   * Helper method to get the name of the process this instance is running in using the {@link
   * ActivityManager#getRunningAppProcesses}.
   *
   * <p>{@link ActivityManager#getRunningAppProcesses} method unfortunately was only designed for
   * aiding debuggin and it is known in some circunstancies to not return the current process in the
   * list (see http://b/152836562 for an example).
   *
   * @param context the context this process is running in.
   * @return returns the current process name or an empty sting if one cannot be found.
   */
  @VisibleForTesting
  static String getCurrentProcessNameUsingActivityManager(Context context) {
    int pid = android.os.Process.myPid();
    ActivityManager activityManager =
        (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);

    if (activityManager != null) {
      List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
      if (null == runningAppProcesses) {
        int retryAttempt = 0;
        // Retry getting running app processes
        while (null == runningAppProcesses && retryAttempt < RETRY_WAIT_INTERVALS.size()) {
          try {
            Log.i(TAG, "Waiting for running app processes...");
            Thread.sleep(RETRY_WAIT_INTERVALS.get(retryAttempt++));
            runningAppProcesses = activityManager.getRunningAppProcesses();
          } catch (InterruptedException ie) {
            Log.w(TAG, "Interrupted while waiting for running app processes", ie);
            return "";
          }
        }
      }

      for (ActivityManager.RunningAppProcessInfo processInfo : emptyIfNull(runningAppProcesses)) {
        if (processInfo.pid == pid) {
          return processInfo.processName;
        }
      }
      Log.w(TAG, "Couldn't get running processes from ActivityManager!");
    } else {
      Log.w(
          TAG,
          "ActivityManager#getRunningAppProcesses did not return an entry matching pid = " + pid);
    }
    return "";
  }

  private static <E> Iterable<E> emptyIfNull(Iterable<E> iterable) {
    return null == iterable ? Collections.emptyList() : iterable;
  }

  /**
   * Helper method to get the name of the process this instance is running in using information
   * published by the kernel in the /proc process.
   *
   * <p>This method is unfortunately only reliable if the current process name is relatively short.
   * We have empircally seen process names truncated at 75 chars but it could be even less.
   *
   * @return returns the current process name or an empty sting if one cannot be found.
   */
  @VisibleForTesting
  static String getCurrentProcessNameUsingProc() {
    BufferedReader br = null;
    String processName = "";
    try {
      br = new BufferedReader(new FileReader("/proc/self/cmdline"));
      processName = br.readLine().trim();
    } catch (IOException e) {
      Log.e(TAG, e.getMessage(), e);
    } finally {
      try {
        if (br != null) {
          br.close();
        }
      } catch (Exception e) {
        Log.w(TAG, e.getMessage(), e);
      }
    }
    return processName;
  }

  /** Only call this method to reset state in tests! */
  @VisibleForTesting
  static void resetProcessName() {
    processName = "";
  }
}
