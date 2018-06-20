package com.beck.helloschoolmate.view.fragment.userinfo;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.beck.helloschoolmate.R;
import com.beck.helloschoolmate.activity.userinfo.MyInformationActivity;
import com.beck.helloschoolmate.contract.MyInfoAllContract;
import com.beck.helloschoolmate.model.http.entity.userinfo.MyInfoResponse;
import com.beck.helloschoolmate.util.UIUtil;
import com.beck.helloschoolmate.view.fragment.MateBaseFragment;
import com.beck.helloschoolmate.view.widget.CircleImageView;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by beck on 2018/6/15.
 */

public class MyInfoFragment extends MateBaseFragment<MyInformationActivity> implements MyInfoAllContract.View {

    private MyInfoAllContract.Presenter presenter;
    @BindView(R.id.civ_myInfo_icon)
    CircleImageView civMyInfoIcon;

    @BindView(R.id.tv_myInfo_num)
    TextView tvMyInfoNum;

    @BindView(R.id.tv_myInfo_sex)
    TextView tvMyInfoSex;

    @BindView(R.id.tv_myInfo_address)
    TextView tvMyInfoAddress;

    @BindView(R.id.tv_myInfo_homePlace)
    TextView tvMyInfoHomePlace;

    @BindView(R.id.tv_myInfo_work)
    TextView tvMyInfoWork;

    @BindView(R.id.tv_myInfo_hobby)
    TextView tvMyInfoHobby;

    @BindView(R.id.tv_myInfo_signature)
    TextView tvMyInfoSignature;

    @BindView(R.id.tv_myInfo_remarkName)
    TextView tvMyInfoRemarkName;
    Unbinder unbinder;
    private Dialog loadingDialog;

    public static MyInfoFragment newInstance() {
        return new MyInfoFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_myinfo_all, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mActivity.setToolbarBackTitle("");
        presenter.subscribe();
        loadingDialog = UIUtil.createLoadingDialog(this.getContext(), "正在加载...");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @OnClick({R.id.civ_myInfo_icon, R.id.btn_myInfo_update})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.civ_myInfo_icon:

                break;
            case R.id.btn_myInfo_update:

                break;
        }
    }

    @Override
    public void requestError(String error) {
        Toast.makeText(this.getContext(), error, Toast.LENGTH_SHORT).show();
        UIUtil.closeDialog(loadingDialog);
    }

    @Override
    public void setPresenter(MyInfoAllContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public MyInfoAllContract.Presenter getPresenter() {
        return presenter;
    }

    @Override
    public void displayMyInfo(MyInfoResponse.ResultBean result) {
        UIUtil.closeDialog(loadingDialog);
        StringBuilder stringBuilder = new StringBuilder();
        if (result.getUserImgs() != null) {
            if (result.getUserImgs().size() > 0) {
                Glide.with(this.getContext()).load(result.getUserImgs().get(0)).error(R.mipmap.user_icon).into(civMyInfoIcon);
            }
        } else {
            Glide.with(this.getContext()).load(R.mipmap.user_icon).into(civMyInfoIcon);
        }
        tvMyInfoRemarkName.setText(result.getNickName());
        tvMyInfoNum.setText(result.getAccount());
        tvMyInfoAddress.setText(result.getArea());
        tvMyInfoHomePlace.setText(result.getHomeplace());
        int sex = result.getSex();
        if (sex == 1) {
            tvMyInfoSex.setText("男");
        } else if (sex == 0) {
            tvMyInfoSex.setText("女");
        } else {
            tvMyInfoSex.setText("保密");
        }
        if (result.getHobbies() != null && result.getHobbies().size() > 0) {
            for (int i = 0; i < result.getHobbies().size(); i++) {
                stringBuilder.append(result.getHobbies().get(i)).append(" ");
            }
            tvMyInfoHobby.setText(stringBuilder.toString());
        } else {
            tvMyInfoHobby.setText("");
        }
        tvMyInfoSignature.setText(result.getSignature());
        tvMyInfoWork.setText(result.getIndustry());
    }

}
