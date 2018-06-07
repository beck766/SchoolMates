package com.beck.helloschoolmate.activity.login;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.beck.base.activity.BaseRFActivity;
import com.beck.helloschoolmate.R;
import com.beck.helloschoolmate.view.fragment.register.RegisterPhoneNumFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by beck on 2018/5/21.
 * register
 */

public class RegisterActivity extends BaseRFActivity {
    private static final String TAG = "RegisterActivity";
    private List<Fragment> fragments = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);
        setToolbarBackTitle("账号注册");
        if (savedInstanceState == null) {
            setFragment(RegisterPhoneNumFragment.newInstance(), "register_phoneNum", false);
        }
    }

    public void setFragment(Fragment fragment, String tag, boolean pullToStack) {
        if (!fragments.contains(fragment)) {
            fragments.add(fragment);
        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container_general, fragment, tag);
        if (pullToStack) ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}
