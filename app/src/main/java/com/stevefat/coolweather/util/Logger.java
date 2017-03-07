package com.stevefat.coolweather.util;

import android.util.Log;

/**
 * Created by stevefat on 2017/3/6.
 */

public class Logger {
    private static  String TAG = "Logger";
    private static LogLevel logLevel = LogLevel.FULL;

    public Logger init(){
        return this;
    }
    public Logger init(String tag) {
        this.TAG = tag;
        return this;
    }

    public Logger setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
        return this;
    }

    private static LogLevel getLogLevel() {
        return logLevel;
    }

    public static void e(String args) {
        if (getLogLevel() == LogLevel.NONE) {
            return;
        }
        Log.e(TAG, args);
    }

    public static void d(String args) {
        if (getLogLevel() == LogLevel.NONE) {
            return;
        }
        Log.d(TAG, args);
    }

    public static void v(String args) {
        if (getLogLevel() == LogLevel.NONE) {
            return;
        }
        Log.v(TAG, args);
    }

    public static void i(String args) {
        if (getLogLevel() == LogLevel.NONE) {
            return;
        }
        Log.i(TAG, args);
    }

    public static void w(String args) {
        if (getLogLevel() == LogLevel.NONE) {
            return;
        }
        Log.w(TAG, args);
    }


}
