package com.beck.helloschoolmate.view.fragment.addfriend;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.beck.helloschoolmate.R;
import com.beck.helloschoolmate.activity.AddFriendActivity;
import com.beck.helloschoolmate.model.http.entity.addfriend.AddFriSearchResponse;
import com.beck.helloschoolmate.presenter.AddFriSendPresenter;
import com.beck.helloschoolmate.view.fragment.MateBaseFragment;
import com.beck.helloschoolmate.view.widget.CircleImageView;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by beck on 2018/6/2.
 */

public class AddFriendInfoFragment extends MateBaseFragment<AddFriendActivity> {

    @BindView(R.id.civ_search_icon)
    CircleImageView civSearchIcon;

    @BindView(R.id.tv_search_num)
    TextView tvSearchNum;

    @BindView(R.id.tv_search_name)
    TextView tvSearchName;

    @BindView(R.id.tv_search_sex)
    TextView tvSearchSex;

    @BindView(R.id.tv_search_address)
    TextView tvSearchAddress;

    @BindView(R.id.tv_search_homePlace)
    TextView tvSearchHomePlace;

    @BindView(R.id.tv_search_work)
    TextView tvSearchWork;

    @BindView(R.id.tv_search_hobby)
    TextView tvSearchHobby;

    @BindView(R.id.tv_search_signature)
    TextView tvSearchSignature;
    Unbinder unbinder;
    private AddFriSearchResponse addFriSearchResponse;

    public static AddFriendInfoFragment newInstance() {
        return new AddFriendInfoFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_addfriend_info, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mActivity.setToolbarBackTitle("用户信息");
        initData();
    }

    private void initData() {
        addFriSearchResponse = getArguments().getParcelable("addFriSearchResponse");
        if (addFriSearchResponse != null) {
            tvSearchNum.setText(addFriSearchResponse.getResult().getAccount());
            tvSearchName.setText(addFriSearchResponse.getResult().getNickName());
            int sex = addFriSearchResponse.getResult().getSex();
            if (sex == 1) {
                tvSearchSex.setText("男");
            } else if (sex == 0) {
                tvSearchSex.setText("女");
            } else {
                tvSearchSex.setText("保密");
            }
            tvSearchAddress.setText(addFriSearchResponse.getResult().getArea());
            tvSearchHomePlace.setText(addFriSearchResponse.getResult().getHomeplace());
            tvSearchWork.setText(addFriSearchResponse.getResult().getIndustry());
            tvSearchHobby.setText(addFriSearchResponse.getResult().getHobbies());
            tvSearchSignature.setText(addFriSearchResponse.getResult().getSignature());
            Glide.with(this).load(addFriSearchResponse.getResult().getUserIcons()).placeholder(R.mipmap.user_icon).error(R.mipmap.user_icon).into(civSearchIcon);
        }

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_search_send)
    public void onViewClicked() {
        AddFriendSendFragment addFriendSendFragment = AddFriendSendFragment.newInstance();
        Bundle bundle = new Bundle();
        bundle.putString("addFriendSend_userId", addFriSearchResponse.getResult().getAccount());
        addFriendSendFragment.setArguments(bundle);
        mActivity.setFragment(addFriendSendFragment, "addFriend_send", true);
        new AddFriSendPresenter(mActivity, addFriendSendFragment);
    }
}
