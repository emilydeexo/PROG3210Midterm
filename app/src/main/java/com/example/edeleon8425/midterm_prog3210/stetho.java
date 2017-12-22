package com.example.edeleon8425.midterm_prog3210;

import android.app.Application;
import com.facebook.stetho.Stetho;

public class stetho extends Application {
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}