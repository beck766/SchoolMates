package com.beck.helloschoolmate.activity.friend;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.beck.base.activity.BaseRFActivity;
import com.beck.helloschoolmate.R;
import com.beck.helloschoolmate.presenter.NewFriCheckPresenter;
import com.beck.helloschoolmate.view.fragment.newfriend.NewFriCheckFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by beck on 2018/6/7.
 */

public class CheckNewFriActivity extends BaseRFActivity {
    private List<Fragment> fragments = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);
        if (savedInstanceState == null) {
            NewFriCheckFragment newFriCheckFragment = NewFriCheckFragment.newInstance();
            setFragment(newFriCheckFragment, "newFriend_check", false);
            new NewFriCheckPresenter(this, newFriCheckFragment);
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
    }
}
