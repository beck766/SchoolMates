package com.beck.helloschoolmate.view.fragment.homepage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beck.helloschoolmate.R;
import com.beck.helloschoolmate.view.fragment.HomeBaseFragment;

/**
 * Created by beck on 2018/5/17.
 */

public class StateFragment extends HomeBaseFragment{
    private static final String TAG = "StateFragment";
    public static StateFragment newInstance() {
        return new StateFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_state, container, false);
        Log.i(TAG, "onCreateView: ");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "onActivityCreated: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }
}
