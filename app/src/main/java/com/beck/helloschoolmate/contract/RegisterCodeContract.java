package com.beck.helloschoolmate.contract;

import com.beck.base.presenter.BasePresenter;
import com.beck.base.view.BaseView;
import com.beck.helloschoolmate.model.http.entity.user.GetCodeRequest;
import com.beck.helloschoolmate.model.http.entity.user.VerfiyCodeRequest;

/**
 * Created by beck on 2018/5/29.
 */

public interface RegisterCodeContract {

    interface View extends BaseView<RegisterCodeContract.Presenter> {
        void RequestError(String error);

        void getCodeSuccess(boolean isSuccess);

        void verfiySussess(String userToken);
    }

    interface Presenter extends BasePresenter {
        void getVerfiyCode(GetCodeRequest getCodeRequest);

        void verfiyCode(VerfiyCodeRequest verfiyCodeRequest);
    }
}
