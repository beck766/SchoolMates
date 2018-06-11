package com.beck.helloschoolmate.contract;

import com.beck.base.presenter.BasePresenter;
import com.beck.base.view.BaseView;
import com.beck.helloschoolmate.model.http.entity.friend.FriendResponse;

import java.util.List;

/**
 * Created by beck on 2018/6/11.
 */

public interface FriendListContract {
    interface View extends BaseView<FriendListContract.Presenter> {

        void displayFriList(List<FriendResponse.ResultBean> result);
    }

    interface Presenter extends BasePresenter {

    }
}
