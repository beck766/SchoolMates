package com.beck.helloschoolmate.view.fragment.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.beck.helloschoolmate.R;
import com.beck.helloschoolmate.activity.friend.CheckNewFriActivity;
import com.beck.helloschoolmate.view.fragment.HomeBaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by beck on 2018/5/17.
 */

public class LinkmanFragment extends HomeBaseFragment {

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
}
