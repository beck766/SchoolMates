package com.beck.base.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by beck on 2018/5/16.
 * BaseActivity
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
