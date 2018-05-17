package com.beck.helloschoolmate.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.beck.base.fragment.BaseFragment;
import com.beck.helloschoolmate.activity.HomePageActivity;

/**
 * Created by beck on 2018/5/17.
 */

public abstract class HomeBaseFragment extends BaseFragment {

    private static final String TAG = "HomeBaseFragment";
    protected HomePageActivity activity;

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity = (HomePageActivity) getActivity();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    protected void setFragmentTitle(int res_id) {
        setHeaderViewVisibility(View.VISIBLE);
        activity.getTitleView().setText(res_id);
    }

    protected void setContainerBackground(int res_id) {
        activity.getContainerView().setBackgroundResource(res_id);
    }

    protected void setTitleViewVisibility(int visibility) {
        setHeaderViewVisibility(View.VISIBLE);
        activity.getTitleView().setVisibility(visibility);
    }

    protected void setRightViewVisibility(int visibility) {
        setHeaderViewVisibility(View.VISIBLE);
        activity.getRightView().setVisibility(visibility);
    }

    protected void setLeftViewVisibility(int visibility) {
        setHeaderViewVisibility(View.VISIBLE);
        activity.getLeftView().setVisibility(visibility);
    }

    protected void setFragmentRight(int  res_id) {
        setHeaderViewVisibility(View.VISIBLE);
        setRightViewVisibility(View.VISIBLE);
        activity.getContainerView().setBackgroundResource(res_id);
    }

    protected void setFragmentRightListener(View.OnClickListener onClickListener) {
        setHeaderViewVisibility(View.VISIBLE);
        activity.getRightView().setOnClickListener(onClickListener);
    }

    protected void setHeaderViewVisibility(int visibility) {
        activity.getHeaderView().setVisibility(visibility);
    }

}
