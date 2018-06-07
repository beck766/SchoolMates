package com.beck.helloschoolmate.view.fragment.register;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.beck.base.util.NetworkUtils;
import com.beck.helloschoolmate.R;
import com.beck.helloschoolmate.activity.login.RegisterActivity;
import com.beck.helloschoolmate.contract.RegisterCodeContract;
import com.beck.helloschoolmate.model.http.entity.user.GetCodeRequest;
import com.beck.helloschoolmate.model.http.entity.user.VerfiyCodeRequest;
import com.beck.helloschoolmate.presenter.RegisterPasswordPresenter;
import com.beck.helloschoolmate.view.fragment.MateBaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by beck on 2018/5/21.
 */

public class RegisterCodeFragment extends MateBaseFragment<RegisterActivity> implements RegisterCodeContract.View {

    private static final String TAG = "RegisterCodeFragment";

    private RegisterCodeContract.Presenter presenter;
    @BindView(R.id.register_et_verifyCode)
    EditText registerEtVerifyCode;

    @BindView(R.id.register_btn_next)
    Button registerBtnNext;
    private String tel;

    public static RegisterCodeFragment newInstance() {
        return new RegisterCodeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register_code, container, false);
        ButterKnife.bind(this, view);
        registerEtVerifyCode.addTextChangedListener(textWatcher);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mActivity.setToolbarBackTitle("验证");
        tel = getArguments().getString("tel");
        Log.i(TAG, "onViewCreated: 手机号为:" + tel);
    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @SuppressLint("LongLogTag")
        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String code = registerEtVerifyCode.getText().toString();
            if (code.length() >= 6) {
                registerBtnNext.setEnabled(true);
            } else {
                registerBtnNext.setEnabled(false);
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @OnClick({R.id.register_btn_getVerfiyCode, R.id.register_btn_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.register_btn_getVerfiyCode:
                if (!NetworkUtils.isNetworkConnected(mActivity)) {
                    Toast.makeText(mActivity, "网络不稳定！", Toast.LENGTH_SHORT).show();
                } else {
                    GetCodeRequest getCodeRequest = new GetCodeRequest();
                    getCodeRequest.setPhoneNumber(tel);
                    presenter.getVerfiyCode(getCodeRequest);
                }
                break;
            case R.id.register_btn_next:
                if (!NetworkUtils.isNetworkConnected(mActivity)) {
                    Toast.makeText(mActivity, "网络不稳定！", Toast.LENGTH_SHORT).show();
                } else {
                    VerfiyCodeRequest verfiyCodeRequest = new VerfiyCodeRequest();
                    verfiyCodeRequest.setCaptcha(registerEtVerifyCode.getText().toString().trim());
                    presenter.verfiyCode(verfiyCodeRequest);
                }
                break;
        }
    }

    @Override
    public void requestError(String error) {
        Toast.makeText(mActivity, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(RegisterCodeContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public RegisterCodeContract.Presenter getPresenter() {
        return presenter;
    }

    @Override
    public void getCodeSuccess(boolean isSuccess) {
        if (isSuccess) {
            Toast.makeText(mActivity, "获取成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(mActivity, "获取失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void verfiySussess(String userToken) {
        RegisterPasswordFragment registerPasswordFragment = RegisterPasswordFragment.newInstance();
        Bundle bundle = new Bundle();
        bundle.putString("tel", tel);
        bundle.putString("accessToken",userToken);
        registerPasswordFragment.setArguments(bundle);
        mActivity.setFragment(registerPasswordFragment, "register_password", true);
        new RegisterPasswordPresenter(mActivity,registerPasswordFragment);
    }
}
