package com.beck.helloschoolmate.contract;

import com.beck.base.presenter.BasePresenter;
import com.beck.base.view.BaseView;
import com.beck.helloschoolmate.model.http.entity.addfriend.AddFriSearchRequest;
import com.beck.helloschoolmate.model.http.entity.addfriend.AddFriSearchResponse;

/**
 * Created by beck on 2018/6/2.
 */

public interface AddFriSearchContract {

    interface View extends BaseView<AddFriSearchContract.Presenter> {
        void RequestError(String error);

        void searchSuccess(AddFriSearchResponse addFriSearchResponse);
    }

    interface Presenter extends BasePresenter {
        void search(AddFriSearchRequest addFriSearchRequest);
    }
}
