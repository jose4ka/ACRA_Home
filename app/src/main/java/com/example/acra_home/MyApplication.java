package com.example.acra_home;

import android.app.Application;
import android.content.Context;

import com.example.acra_home.acra.ACRASenderFactory;

import org.acra.ACRA;
import org.acra.annotation.AcraCore;

@AcraCore(reportSenderFactoryClasses = ACRASenderFactory.class)

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ACRA.init(this);
    }

}
