package com.example.administrator.shortbreaddemo;

import android.app.Application;
import android.content.Context;

import shortbread.Shortbread;

public class SampleApplication extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        Shortbread.create(this);
    }
}
