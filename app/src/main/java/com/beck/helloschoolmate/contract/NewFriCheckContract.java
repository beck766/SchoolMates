package com.beck.helloschoolmate.contract;

import com.beck.base.presenter.BasePresenter;
import com.beck.base.view.BaseView;
import com.beck.helloschoolmate.model.http.entity.friend.NewFriCheckResponse;

/**
 * Created by beck on 2018/6/7.
 */

public interface NewFriCheckContract {
    interface View extends BaseView<NewFriCheckContract.Presenter> {

        void requestSuccess(NewFriCheckResponse newFriCheckResponse);
    }

    interface Presenter extends BasePresenter {

    }
}
