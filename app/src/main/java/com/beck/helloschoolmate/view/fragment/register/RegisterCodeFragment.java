package com.beck.helloschoolmate.view.fragment.register;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beck.helloschoolmate.R;
import com.beck.helloschoolmate.activity.RegisterActivity;
import com.beck.helloschoolmate.view.fragment.RegisterBaseFragment;

/**
 * Created by beck on 2018/5/21.
 */

public class RegisterCodeFragment extends RegisterBaseFragment<RegisterActivity>{

    private static final String TAG = "RegisterCodeFragment";

    public static RegisterCodeFragment newInstance() {
        return new RegisterCodeFragment();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_code, container, false);
        return view;

    }
}
