package com.dhcc.visa.app;

import android.app.Application;

/**
 * Created by Lituo on 2017/4/5 0005. 15:47 .
 * Mail：tony1994_vip@163.com
 * 应用程序初始化
 */

public class VisaApplication extends Application {

    private static VisaApplication visaApplication;

    /*应用初始化*/

    @Override
    public void onCreate() {
        super.onCreate();
        visaApplication = this;
    }

    /**
     * 获取Application
     *
     * @return Application
     */
    public static VisaApplication getApplication() {
        return visaApplication;
    }
}
