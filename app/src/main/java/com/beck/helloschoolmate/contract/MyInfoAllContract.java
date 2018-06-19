package com.beck.helloschoolmate.contract;

import com.beck.base.presenter.BasePresenter;
import com.beck.base.view.BaseView;
import com.beck.helloschoolmate.model.http.entity.userinfo.MyInfoResponse;

/**
 * Created by beck on 2018/6/15.
 */

public interface MyInfoAllContract {
    interface View extends BaseView<Presenter> {

        void displayMyInfo(MyInfoResponse.ResultBean result);
    }

    interface Presenter extends BasePresenter {

    }
}
