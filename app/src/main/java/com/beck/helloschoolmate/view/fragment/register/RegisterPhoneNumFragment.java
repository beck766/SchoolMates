package com.beck.helloschoolmate.view.fragment.register;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.beck.helloschoolmate.R;
import com.beck.helloschoolmate.activity.login.RegisterActivity;
import com.beck.helloschoolmate.presenter.RegisterCodePresenter;
import com.beck.helloschoolmate.view.fragment.MateBaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by beck on 2018/5/21.
 */

public class RegisterPhoneNumFragment extends MateBaseFragment<RegisterActivity> {

    private static final String TAG = "RegisterPhoneNumFragment";
    @BindView(R.id.register_et_tel)
    EditText registerEtTel;

    @BindView(R.id.register_btn_next)
    Button registerBtnNext;

    public static RegisterPhoneNumFragment newInstance() {
        return new RegisterPhoneNumFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register_phone, container, false);
        ButterKnife.bind(this, view);
        registerEtTel.addTextChangedListener(textWatcher);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mActivity.setToolbarBackTitle("账号注册");
    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @SuppressLint("LongLogTag")
        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String tel = registerEtTel.getText().toString();
            if (tel.length() >= 11) {
                registerBtnNext.setEnabled(true);
                Log.i(TAG, "onTextChanged: Enabled=" + true);
            } else {
                registerBtnNext.setEnabled(false);
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    public static boolean isMobile(String number) {
        String num = "[1][3456789]\\d{9}";
        if (TextUtils.isEmpty(number)) return false;
        else return number.matches(num);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @OnClick(R.id.register_btn_next)
    public void onViewClicked() {
        String tel = registerEtTel.getText().toString();
        if (isMobile(tel)) {
            isVerify(tel);
        } else {
            Toast.makeText(mActivity, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();
        }
    }

    private void isVerify(String tel) {
        // TODO: 2018/5/22 验证手机号是否存在
        RegisterCodeFragment registerCodeFragment = RegisterCodeFragment.newInstance();
        Bundle bundle = new Bundle();
        bundle.putString("tel", registerEtTel.getText().toString());
        registerCodeFragment.setArguments(bundle);
        mActivity.setFragment(registerCodeFragment, "register_code", true);
        new RegisterCodePresenter(mActivity,registerCodeFragment);
    }
}
