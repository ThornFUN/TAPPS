package com.demo.thorn.tapps;

import android.app.Application;
import android.content.Context;

/**
 * Created by pengj on 2018-6-19.
 * Github https://github.com/ThornFUN
 * Function:
 */

public class TAPPSApplication extends Application {

    public static Context appContext;
    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this.getApplicationContext();
    }

    public static Context getAppContext() {
        return appContext;
    }
}
