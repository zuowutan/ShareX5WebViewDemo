package com.example.administrator.sharex5webviewdemo.tools;

import android.util.Log;

/**
 * Created by tzw on 2018/3/13.
 */

public class Logger {

    //   是否开启日志
    public static final boolean logTAG = true;
    //   默认日志TAG
    public static final String TAG = "log";
    //   不写日志TAG 只输出日志信息
    public static void i(String desData) {
        if (logTAG) {
            Log.i(TAG, desData);
        } else {
            Log.i(TAG, "desData was close ");
        }
    }

    //  自定义日志TAG ===>> 输出日志信息
    public static void i(String debugTag, String debugData) {
        if (logTAG) {
            Log.i(debugTag, debugData);
        } else {
            Log.i(debugTag, "debugData was close ");
        }
    }

    public static void e(String debugData) {
        if (logTAG) {
            Log.e(TAG, " :" + debugData);
        } else {
            Log.e(TAG, "debugData was close ");
        }
    }

    public static void e(String debugTag, String debugData) {
        if (logTAG) {
            Log.e(debugTag, " :" + debugData);
        } else {
            Log.e(debugTag, "debugData was close ");

        }
    }

}
