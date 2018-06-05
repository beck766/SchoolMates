package com.beck.helloschoolmate.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.beck.base.activity.BaseRFActivity;
import com.beck.helloschoolmate.R;
import com.beck.helloschoolmate.presenter.AddFriSearchPresenter;
import com.beck.helloschoolmate.view.fragment.addfriend.AddFriendSearchFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by beck on 2018/6/2.
 * AddFriendActivity
 */

public class AddFriendActivity extends BaseRFActivity {

    private List<Fragment> fragments = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);
        if (savedInstanceState == null) {
            AddFriendSearchFragment addFriendSearchFragment = AddFriendSearchFragment.newInstance();
            setFragment(addFriendSearchFragment, "addFriend_search", false);
            new AddFriSearchPresenter(this, addFriendSearchFragment);
        }
    }

    public void setFragment(Fragment fragment, String tag, boolean pullToStack) {
        if (!fragments.contains(fragment)) {
            fragments.add(fragment);
        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container_addFriend, fragment, tag);
        if (pullToStack) ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
