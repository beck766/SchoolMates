package com.beck.helloschoolmate.view.fragment.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.beck.helloschoolmate.R;
import com.beck.helloschoolmate.activity.friend.CheckNewFriActivity;
import com.beck.helloschoolmate.contract.FriendListContract;
import com.beck.helloschoolmate.model.http.entity.friend.FriendResponse;
import com.beck.helloschoolmate.view.adapter.MyFriendAdapter;
import com.beck.helloschoolmate.view.fragment.HomeBaseFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by beck on 2018/5/17.
 */

public class LinkmanFragment extends HomeBaseFragment implements FriendListContract.View {

    private FriendListContract.Presenter presenter;
    @BindView(R.id.rcv_linkman_friend)
    RecyclerView rcvLinkmanFriend;

    @BindView(R.id.rl_linkman_newFriend)
    RelativeLayout rlLinkmanNewFriend;

    @BindView(R.id.tv_linkman_search)
    TextView tvLinkmanSearch;

    public static LinkmanFragment newInstance() {
        return new LinkmanFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_linkman, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.subscribe();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @OnClick(R.id.rl_linkman_newFriend)
    public void onViewClicked() {
        Intent intent = new Intent(getActivity(), CheckNewFriActivity.class);
        startActivity(intent);
    }

    @Override
    public void requestError(String error) {
        Toast.makeText(activity, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(FriendListContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public FriendListContract.Presenter getPresenter() {
        return presenter;
    }

    @Override
    public void displayFriList(List<FriendResponse.ResultBean> result) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
        rcvLinkmanFriend.setLayoutManager(layoutManager);
        rcvLinkmanFriend.setItemAnimator(new DefaultItemAnimator());
        MyFriendAdapter myFriendAdapter = new MyFriendAdapter(this.getContext(), result);
        rcvLinkmanFriend.setAdapter(myFriendAdapter);
    }
}
