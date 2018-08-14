package com.beck.helloschoolmate.contract;

import com.beck.base.presenter.BasePresenter;
import com.beck.base.view.BaseView;
import com.beck.helloschoolmate.model.http.entity.register.RegisterCheckRequest;
import com.beck.helloschoolmate.model.http.entity.register.RegisterRequest;

/**
 * Created by beck on 2018/5/30.
 *
 */

public interface RegisterPasswordContract {

    interface View extends BaseView<RegisterPasswordContract.Presenter> {

        void registerSuccess();

        void checkDisplay(String s);

        void checkDisplayFalse(String errorMsg);
    }

    interface Presenter extends BasePresenter {

        void register(String accessToken, RegisterRequest registerRequest);

        void checkoutAccount(RegisterCheckRequest registerCheckRequest);
    }
}
