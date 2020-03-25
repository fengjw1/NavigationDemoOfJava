package com.example.navigationdemoofjava.utils;

import android.util.Log;

import java.util.Locale;

/**
 * Created by fengjw on 2018/1/12.
 */

public class LogUtils {

    private static final Boolean DEBUG = true;//BuildConfig.DEBUG;

    private static boolean LOGV = DEBUG;
    private static boolean LOGD = DEBUG;
    private static boolean LOGI = DEBUG;
    private static boolean LOGW = DEBUG;
    private static boolean LOGE = DEBUG;

    public static void v(String tag, String message){
        if (LOGV){
            Log.v(tag, message);
        }
    }
    public static void d(String tag, String message){
        if (LOGD){
            Log.d(tag, message);
        }
    }
    public static void i(String tag, String message){
        if (LOGI){
            Log.i(tag, message);
        }
    }
    public static void w(String tag, String message){
        if (LOGW){
            Log.i(tag, message);
        }
    }
    public static void e(String tag, String message){
        if (LOGE){
            Log.e(tag, message);
        }
    }

    /**
     * obtian caller class name
     * @return class name
     */
    private static String getTag(){
        StackTraceElement[] trace = new Throwable().fillInStackTrace().getStackTrace();
        String callingClass = "";
        for (int i = 2; i < trace.length; i ++){
            Class<?> clazz = trace[i].getClass();
            if (!clazz.equals(LogUtils.class)){
                callingClass = trace[i].getClassName();
                callingClass = callingClass.substring(callingClass.lastIndexOf('.')+  1);
                break;
            }
        }
        return  callingClass;
    }

    /**
     * direct output log message
     */
    public static void v(String message){
        if (LOGV)
            Log.v(getTag(), message);
    }
    public static void d(String message){
        if (LOGD)
            Log.d(getTag(), message);
    }
    public static void i(String message){
        if (LOGI)
            Log.i(getTag(), message);
    }
    public static void w(String message){
        if (LOGW)
            Log.w(getTag(), message);
    }
    public static void e(String message){
        if (LOGE)
            Log.e(getTag(), message);
    }

    /**
     * obtain Thread ID, Method Name, Output Message
     * @param  message
     * @return String
     */
    private static String buildMessage(String message){
        StackTraceElement[] trace = new Throwable().fillInStackTrace().getStackTrace();
        String caller = "";
        for (int i = 2; i < trace.length; i ++){
            Class<?> clazz = trace[i].getClass();
            if (clazz.equals(LogUtils.class)){
                caller = trace[i].getMethodName();
                break;
            }
        }
        return String.format(Locale.US, "[%d] %s : %s", Thread.currentThread().getId(),
                caller, message);
    }

    /**
     * direct output Thread ID, Method Name, Output Message
     * Not define Tag
     */
    public static void vThread(String message){
        if (LOGV)
            Log.v(getTag(), buildMessage(message));
    }
    public static void dThread(String message){
        if (LOGD)
            Log.d(getTag(), buildMessage(message));
    }
    public static void wThread(String message){
        if (LOGW)
            Log.w(getTag(), buildMessage(message));
    }
    public static void iThread(String message){
        if (LOGI)
            Log.i(getTag(), buildMessage(message));
    }
    public static void eThread(String message){
        if (LOGE)
            Log.e(getTag(), buildMessage(message));
    }
}
