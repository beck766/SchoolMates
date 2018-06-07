package com.beck.helloschoolmate.contract;

import com.beck.base.presenter.BasePresenter;
import com.beck.base.view.BaseView;
import com.beck.helloschoolmate.model.http.entity.user.LoginRequest;
import com.beck.helloschoolmate.model.http.entity.user.LoginResponse;
import com.beck.helloschoolmate.model.preference.entity.LoginUserInfo;

/**
 * Created by beck on 2018/5/22.
 */

public interface LoginContract {

    interface View extends BaseView<Presenter> {
        void loginSuccess(LoginResponse loginResponse);
        void InitUserInfo(LoginUserInfo loginUserInfo);
    }

    interface Presenter extends BasePresenter {
        void setData(LoginUserInfo loginUserInfo);
        void getUerInfo(LoginRequest loginRequest);
    }
}
