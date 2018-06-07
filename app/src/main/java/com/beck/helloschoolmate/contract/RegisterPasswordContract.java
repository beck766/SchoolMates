package com.beck.helloschoolmate.contract;

import com.beck.base.presenter.BasePresenter;
import com.beck.base.view.BaseView;
import com.beck.helloschoolmate.model.http.entity.user.RegisterRequest;

/**
 * Created by beck on 2018/5/30.
 */

public interface RegisterPasswordContract {

    interface View extends BaseView<RegisterPasswordContract.Presenter> {

        void registerSuccess();
    }

    interface Presenter extends BasePresenter {

        void register(String accessToken, RegisterRequest registerRequest);
    }
}
