package com.demo.thorn.tapps.util;

/**
 * Created by pengj on 2018-6-19.
 * Github https://github.com/ThornFUN
 * Function:
 */

import android.text.TextUtils;
import android.util.Log;

/**
 * 输出格式:
 *  tagPrefix :className.methodName(Line:lineNumber),
 *  tagPrefix 为空时只输出：className.methodName(Line:lineNumber)
 */
public class LogUtil2 {
    public static String TAG = "TAPP";//log前缀

    public static boolean ISLOGSHOW = true;

    public static void d(String msg) {
        logger("d", msg);
    }
    public static void e(String msg) {
        logger("e", msg);
    }
    public static void i(String msg) {
        logger("i", msg);
    }
    public static void w(String msg) {
        logger("w", msg);
    }

    /**
     *
     * @param type logger级别
     * @param msg   logger内容

     */
    private static void logger(String type, String msg) {
        if (!ISLOGSHOW) {
            return;
        }

        String tag = getTag(getCallerStackTraceElement());

        switch (type){
            case  "i":
                Log.i(tag,msg);
            case  "d":
                Log.d(tag,msg);
                break;
            case  "e":
                Log.e(tag,msg);
                break;
            case  "w":
                Log.w(tag,msg);
                break;
        }
    }


    private static String getTag(StackTraceElement element) {

        String tag = "%s.%s(Line:%d)"; // 占位符

        String callerClazzName = element.getClassName(); // 获取到类名

        callerClazzName = callerClazzName.substring(callerClazzName
                .lastIndexOf(".") + 1);

        tag = String.format(tag, callerClazzName, element.getMethodName(),
                element.getLineNumber()); // 替换tag

        tag = TextUtils.isEmpty(TAG) ? tag : TAG + ":"
                + tag;
        return tag;
    }

    /**
     * 获取线程状态
     * @return
     */
    private static StackTraceElement getCallerStackTraceElement() {
        return Thread.currentThread().getStackTrace()[5];
    }
}