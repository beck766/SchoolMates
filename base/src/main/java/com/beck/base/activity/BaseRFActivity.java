package com.beck.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.beck.base.R;

/**
 * Created by beck on 2018/5/21.
 * BaseRFActivity
 */
public abstract class BaseRFActivity extends AppCompatActivity {

    Toolbar mToolBar;
    TextView mToolbarTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setToolbarBackTitle(String title) {
        mToolBar = (Toolbar) findViewById(R.id.custom_toolbar);
        mToolbarTitle = (TextView) findViewById(R.id.custom_toolbar_title);
        if (mToolBar != null) {
            //将Toolbar显示到界面
            setSupportActionBar(mToolBar);
        }
        mToolbarTitle.setText(title);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mToolBar.setNavigationIcon(R.mipmap.back_icon);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    public void setToolbarBack() {
        mToolBar = (Toolbar) findViewById(R.id.custom_toolbar);
        mToolbarTitle = (TextView) findViewById(R.id.custom_toolbar_title);
        if (mToolBar != null) {
            //将Toolbar显示到界面
            setSupportActionBar(mToolBar);
        }
        mToolbarTitle.setVisibility(View.GONE);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mToolBar.setNavigationIcon(R.mipmap.back_icon);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
