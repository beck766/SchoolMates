package com.beck.helloschoolmate.view.fragment.addfriend;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.beck.helloschoolmate.R;
import com.beck.helloschoolmate.activity.AddFriendActivity;
import com.beck.helloschoolmate.contract.AddFriSendContract;
import com.beck.helloschoolmate.model.http.entity.addfriend.AddFriendSendRequest;
import com.beck.helloschoolmate.util.UIUtil;
import com.beck.helloschoolmate.view.fragment.MateBaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by beck on 2018/6/5.
 */

public class AddFriendSendFragment extends MateBaseFragment<AddFriendActivity> implements AddFriSendContract.View {

    private static final String TAG = "AddFriendSendFragment";
    @BindView(R.id.et_add_send_verfiy)
    EditText etAddSendVerfiy;

    @BindView(R.id.et_add_send_remark)
    EditText etAddSendRemark;
    Unbinder unbinder;
    private String send_userId;
    private AddFriSendContract.Presenter presenter;

    public static AddFriendSendFragment newInstance() {
        return new AddFriendSendFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_addfriend_send, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        send_userId = getArguments().getString("addFriendSend_userId");
        Log.i(TAG, "onViewCreated: userId=" + send_userId);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        UIUtil.hideKeyboard(getView());
    }

    @OnClick(R.id.btn_add_send)
    public void onViewClicked() {
        AddFriendSendRequest addFriendSendRequest = new AddFriendSendRequest();
        addFriendSendRequest.setToUserId(Integer.parseInt(send_userId));
        addFriendSendRequest.setFriendGroupId(0);
        addFriendSendRequest.setMessage(etAddSendVerfiy.getText().toString().trim());
        addFriendSendRequest.setRemarkName(etAddSendRemark.getText().toString().trim());
        presenter.send(addFriendSendRequest);
    }

    @Override
    public void setPresenter(AddFriSendContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public AddFriSendContract.Presenter getPresenter() {
        return presenter;
    }

    @Override
    public void RequestError(String error) {
        Toast.makeText(mActivity, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void searchSuccess() {
        Toast.makeText(mActivity, "发送成功", Toast.LENGTH_SHORT).show();
        mActivity.finish();
    }
}
