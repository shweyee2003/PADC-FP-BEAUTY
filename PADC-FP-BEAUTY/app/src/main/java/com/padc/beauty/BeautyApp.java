package com.padc.beauty;

import android.app.Application;
import android.content.Context;

import com.padc.beauty.sync.BeautySyncAdapter;

/**
 * Created by windows on 9/4/2016.
 */
public class BeautyApp extends Application {
    private static Context context;
    public static final String TAG = "BeautyApp";

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

       // BeautySyncAdapter.initializeSyncAdapter(getContext());
    }

    public static Context getContext() {
        return context;
    }


}
