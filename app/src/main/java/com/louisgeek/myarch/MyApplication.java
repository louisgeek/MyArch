package com.louisgeek.myarch;

import android.app.Application;

import com.louisgeek.myarch.http.okhttp.OkHttpManager;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        OkHttpManager.getInstance().init();
    }
}
