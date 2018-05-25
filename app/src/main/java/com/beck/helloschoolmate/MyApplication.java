package com.beck.helloschoolmate;

import android.app.Application;

import com.beck.helloschoolmate.model.http.ApiClient;
import com.beck.helloschoolmate.model.http.ApiConstants;
import com.beck.helloschoolmate.model.http.service.MatesService;

/**
 * Created by beck on 2018/5/16.
 */

public class MyApplication extends Application {

    public static MyApplication myApplication;

    public static MyApplication getInstance() {
        return myApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ApiClient.initMatesService(ApiConstants.MATE_HOST, MatesService.class);
    }
}
