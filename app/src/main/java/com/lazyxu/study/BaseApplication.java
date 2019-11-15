package com.lazyxu.study;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;


public class BaseApplication extends Application {
    private static BaseApplication MINSTATCE = null;

    public static BaseApplication getInstance() {
        return MINSTATCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        MINSTATCE = this;
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        Stetho.initializeWithDefaults(this);
    }


}
