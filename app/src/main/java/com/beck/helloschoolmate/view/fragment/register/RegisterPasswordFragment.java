package com.beck.helloschoolmate.view.fragment.register;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.beck.base.util.NetworkUtils;
import com.beck.helloschoolmate.R;
import com.beck.helloschoolmate.activity.RegisterActivity;
import com.beck.helloschoolmate.contract.RegisterPasswordContract;
import com.beck.helloschoolmate.model.http.entity.user.RegisterRequest;
import com.beck.helloschoolmate.view.fragment.RegisterBaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by beck on 2018/5/21.
 */

public class RegisterPasswordFragment extends RegisterBaseFragment<RegisterActivity> implements RegisterPasswordContract.View{

    private static final String TAG = "RegisterPasswordFragment";
    private boolean registerPwdShow = false;
    private RegisterPasswordContract.Presenter presenter;
    @BindView(R.id.register_pwd_reset)
    EditText registerPwdReset;

    @BindView(R.id.register_pwd_reset_visibility)
    CheckBox registerPwdResetVisibility;

    @BindView(R.id.register_pwd_ensure)
    EditText registerPwdEnsure;

    @BindView(R.id.register_pwd_ensure_visibility)
    CheckBox registerPwdEnsureVisibility;

    @BindView(R.id.pwd_error_set)
    TextView pwdErrorSet;

    @BindView(R.id.register_complete)
    Button registerComplete;
    Unbinder unbinder;
    private String pwd;
    private String pwdEnsure;
    private String tel;
    private String accessToken;

    public static RegisterPasswordFragment newInstance() {
        return new RegisterPasswordFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register_password, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mActivity.setToolbarBackTitle("设置密码");
        tel = getArguments().getString("tel");
        accessToken = getArguments().getString("accessToken");
        registerPwdReset.addTextChangedListener(textWatcher);
        registerPwdEnsure.addTextChangedListener(textWatcher);
    }

    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.register_pwd_reset_visibility, R.id.register_pwd_ensure_visibility, R.id.register_complete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.register_pwd_reset_visibility:
                if (registerPwdShow) {
                    registerPwdReset.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    registerPwdReset.setSelection(registerPwdReset.getText().length());
                    registerPwdShow = false;
                } else {
                    registerPwdReset.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    registerPwdReset.setSelection(registerPwdReset.getText().length());
                    registerPwdShow = true;
                }
                break;
            case R.id.register_pwd_ensure_visibility:
                if (registerPwdShow) {
                    registerPwdEnsure.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    registerPwdEnsure.setSelection(registerPwdEnsure.getText().length());
                    registerPwdShow = false;
                } else {
                    registerPwdEnsure.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    registerPwdEnsure.setSelection(registerPwdEnsure.getText().length());
                    registerPwdShow = true;
                }
                break;
            case R.id.register_complete:
                if (!pwd.equals(pwdEnsure)) {
                    pwdErrorSet.setVisibility(View.VISIBLE);
                    pwdErrorSet.setText("两次输入的密码不一致");
                } else if (!NetworkUtils.isNetworkConnected(mActivity)) {
                    Toast.makeText(mActivity, "网络不稳定！", Toast.LENGTH_SHORT).show();
                } else {
                    RegisterRequest registerRequest = new RegisterRequest();
                    registerRequest.setPhoneNumber(tel);
                    registerRequest.setPassword(pwdErrorSet.getText().toString().trim());
                    presenter.register(accessToken,registerRequest);
                    break;
                }
        }
    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @SuppressLint("LongLogTag")
        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            pwd = registerPwdReset.getText().toString().trim();
            pwdEnsure = registerPwdEnsure.getText().toString().trim();
            if (pwd.length() >= 6 && pwdEnsure.length() >= 6) {
                registerComplete.setEnabled(true);
            } else {
                registerComplete.setEnabled(false);
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    @Override
    public void setPresenter(RegisterPasswordContract.Presenter presenter) {
        this.presenter=presenter;
    }

    @Override
    public RegisterPasswordContract.Presenter getPresenter() {
        return presenter;
    }

    @Override
    public void RequestError(String error) {
        Toast.makeText(mActivity, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void registerSuccess() {
        mActivity.finish();
    }
}
