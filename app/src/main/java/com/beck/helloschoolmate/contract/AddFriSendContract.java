package com.beck.helloschoolmate.contract;

import com.beck.base.presenter.BasePresenter;
import com.beck.base.view.BaseView;
import com.beck.helloschoolmate.model.http.entity.addfriend.AddFriendSendRequest;

/**
 * Created by beck on 2018/6/5.
 */

public interface AddFriSendContract {

    interface View extends BaseView<AddFriSendContract.Presenter> {
        void searchSuccess();
    }

    interface Presenter extends BasePresenter {
        void send(AddFriendSendRequest addFriendSendRequest);
    }
}
