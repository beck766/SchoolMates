package com.beck.helloschoolmate.view.fragment.newfriend;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.beck.helloschoolmate.R;
import com.beck.helloschoolmate.activity.friend.CheckNewFriActivity;
import com.beck.helloschoolmate.contract.NewFriCheckContract;
import com.beck.helloschoolmate.model.http.entity.friend.NewFriCheckResponse;
import com.beck.helloschoolmate.view.adapter.NewFriendAdapter;
import com.beck.helloschoolmate.view.fragment.MateBaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by beck on 2018/6/7.
 */

public class NewFriCheckFragment extends MateBaseFragment<CheckNewFriActivity> implements NewFriCheckContract.View {

    private static final String TAG = "NewFriCheckFragment";
    private NewFriCheckContract.Presenter presenter;
    @BindView(R.id.srl_newFriend_check)
    SwipeRefreshLayout srlNewFriendCheck;

    @BindView(R.id.rcv_newFriend_check)
    RecyclerView rcvNewFriendCheck;
    Unbinder unbinder;

    public static NewFriCheckFragment newInstance() {
        return new NewFriCheckFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_newfriend_check, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mActivity.setToolbarBackTitle("新朋友");
        srlNewFriendCheck.setProgressViewOffset(true,50,200);
        srlNewFriendCheck.setSize(SwipeRefreshLayout.DEFAULT);//下拉圆圈大小
        srlNewFriendCheck.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light
        );
        srlNewFriendCheck.setOnRefreshListener(() -> presenter.subscribe());
        presenter.subscribe();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void requestError(String error) {
        srlNewFriendCheck.setRefreshing(false);
        Toast.makeText(mActivity, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(NewFriCheckContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public NewFriCheckContract.Presenter getPresenter() {
        return presenter;
    }

    @Override
    public void requestSuccess(NewFriCheckResponse newFriCheckResponse) {
        srlNewFriendCheck.setRefreshing(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
        rcvNewFriendCheck.setLayoutManager(layoutManager);
        rcvNewFriendCheck.setItemAnimator(new DefaultItemAnimator());
        NewFriendAdapter newFriendAdapter = new NewFriendAdapter(this.getContext(), newFriCheckResponse.getResult());
        rcvNewFriendCheck.setAdapter(newFriendAdapter);
    }
}
