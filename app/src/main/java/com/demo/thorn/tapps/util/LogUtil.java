package com.demo.thorn.tapps.util;

import android.util.Log;

import com.demo.thorn.tapps.TAPPSApplication;

/**
 * Created by pengj on 2018-6-19.
 * Github https://github.com/ThornFUN
 * Function:
 */

public class LogUtil{

    public static  final boolean ISLOGSHOW = true;
    public static final String TAG = "THORN";

    public static void v(String msg){
        if(ISLOGSHOW){
            Log.v(TAG,getMsgFormat(msg));
        }
    }
    public static void d(String msg){
        if(ISLOGSHOW){
            Log.v(TAG,getMsgFormat(msg));
        }
    }
    public static void i(String msg){
        if(ISLOGSHOW){
            Log.v(TAG,getMsgFormat(msg));
        }
    }
    public static void w(String msg){
        if(ISLOGSHOW){
            Log.v(TAG,getMsgFormat(msg));
        }
    }
    public static void e(String msg){
        if(ISLOGSHOW){
            Log.v(TAG,getMsgFormat(msg));
        }
    }

    /** 输出格式定义 */
    private static String getMsgFormat(String msg) {
        return msg + " ;" + getFunctionName();
    }

    /**
     * 获取相关数据:类名,方法名,行号等.用来定位行<br>
     * at cn.utils.MainActivity.onCreate(MainActivity.java:17) 就是用來定位行的代碼<br>
     *
     * @return [ Thread:main, at
     *         cn.utils.MainActivity.onCreate(MainActivity.java:17)]
     */
    private static String getFunctionName() {
        StackTraceElement[] sts = Thread.currentThread().getStackTrace();
        if (sts != null) {
            for (StackTraceElement st : sts) {
                if (st.isNativeMethod()) {
                    continue;
                }
                if (st.getClassName().equals(Thread.class.getName())) {
                    continue;
                }
                if (st.getClassName().equals(LogUtil.class.getName())) {
                    continue;
                }
                return "[ Thread:" + Thread.currentThread().getName() + ", at " + st.getClassName() + "." + st.getMethodName()
                        + "(" + st.getFileName() + ":" + st.getLineNumber() + ")" + " ]";
            }
        }
        return null;
    }



}
