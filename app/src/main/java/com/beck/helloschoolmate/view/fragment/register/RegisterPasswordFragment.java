package com.beck.helloschoolmate.view.fragment.register;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beck.helloschoolmate.activity.RegisterActivity;
import com.beck.helloschoolmate.view.fragment.RegisterBaseFragment;

/**
 * Created by beck on 2018/5/21.
 */

public class RegisterPasswordFragment extends RegisterBaseFragment<RegisterActivity>{

    public static RegisterPasswordFragment newInstance() {
        return new RegisterPasswordFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
