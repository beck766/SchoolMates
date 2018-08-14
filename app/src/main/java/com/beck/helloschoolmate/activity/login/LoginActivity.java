package com.beck.helloschoolmate.activity.login;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.beck.base.activity.BaseActivity;
import com.beck.helloschoolmate.R;
import com.beck.helloschoolmate.activity.HomePageActivity;
import com.beck.helloschoolmate.contract.LoginContract;
import com.beck.helloschoolmate.model.http.entity.login.LoginRequest;
import com.beck.helloschoolmate.model.http.entity.login.LoginResponse;
import com.beck.helloschoolmate.model.preference.entity.LoginUserInfo;
import com.beck.helloschoolmate.presenter.LoginPresenter;
import com.beck.helloschoolmate.util.UIUtil;
import com.beck.helloschoolmate.util.UserManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by beck on 2018/5/21.
 * Login
 */

public class LoginActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener, LoginContract.View {

    private static final String TAG = "LoginActivity";
    private LoginContract.Presenter presenter;
    @BindView(R.id.et_phone)
    EditText etPhone;

    @BindView(R.id.et_pwd)
    EditText etPwd;

    @BindView(R.id.cb_display)
    CheckBox cbDisplay;

    @BindView(R.id.btn_next)
    Button btnNext;

    private String phone;
    private String password;
    private Dialog loadingDialog;
    private LoginRequest loginRequest;

    /*@BindView(R.id.pb_loading)
    ProgressBar pbLoading;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initView();
        if (presenter == null) {
            presenter = new LoginPresenter(this, this);
        }
    }

    private void initView() {
        cbDisplay.setOnCheckedChangeListener(this);
        etPhone.addTextChangedListener(textWatcher);
        etPwd.addTextChangedListener(textWatcher);
        loginRequest = new LoginRequest();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
        presenter.subscribe();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            etPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            etPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    @OnClick({R.id.btn_next, R.id.tv_resetPsw, R.id.tv_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_next:
                loginRequest.setAccount(phone);
                loginRequest.setPassword(password);
                presenter.getUerInfo(loginRequest);
                loadingDialog = UIUtil.createLoadingDialog(this, "登录中...");
                break;
            case R.id.tv_resetPsw:
                // TODO: 2018/5/21
                break;
            case R.id.tv_register:
                Intent intent2 = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent2);
                break;
        }
    }

    @Override
    public void requestError(String error) {
        UIUtil.closeDialog(loadingDialog);
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public LoginContract.Presenter getPresenter() {
        return presenter;
    }

    @Override
    public void loginSuccess(LoginResponse loginResponse) {
        UIUtil.closeDialog(loadingDialog);
        if (loginResponse.isSuccess()) {
            UserManager.getInstance().saveLoginUserInfo(this, phone, loginResponse.getResult().getUserToken());
            Intent intent = new Intent(LoginActivity.this, HomePageActivity.class);
            intent.putExtra("userIcon", loginResponse.getResult().getUserIcon());
            startActivity(intent);
        } else {
            Toast.makeText(this, loginResponse.getErrorMsg(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void InitUserInfo(LoginUserInfo loginUserInfo) {
        etPhone.setText(loginUserInfo.getUserNumber());
    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @SuppressLint("LongLogTag")
        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            phone = etPhone.getText().toString().trim();
            password = etPwd.getText().toString().trim();
            if (!password.isEmpty()) {
                btnNext.setEnabled(true);
            } else {
                btnNext.setEnabled(false);
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

}
