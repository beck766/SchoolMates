package com.beck.helloschoolmate.contract;

import com.beck.base.presenter.BasePresenter;
import com.beck.base.view.BaseView;
import com.beck.helloschoolmate.model.http.entity.register.GetCodeRequest;
import com.beck.helloschoolmate.model.http.entity.register.VerfiyCodeRequest;

/**
 * Created by beck on 2018/5/29.
 */

public interface RegisterCodeContract {

    interface View extends BaseView<RegisterCodeContract.Presenter> {

        void getCodeSuccess(boolean isSuccess);

        void verfiySussess(String userToken);
    }

    interface Presenter extends BasePresenter {
        void getVerfiyCode(GetCodeRequest getCodeRequest);

        void verfiyCode(VerfiyCodeRequest verfiyCodeRequest);
    }
}
