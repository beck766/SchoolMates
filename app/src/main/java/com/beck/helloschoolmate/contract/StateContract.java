package com.beck.helloschoolmate.contract;

import com.beck.base.presenter.BasePresenter;
import com.beck.base.view.BaseView;
import com.beck.helloschoolmate.model.http.entity.state.StateResponse;

import java.util.List;

/**
 * Created by beck on 2018/8/11.
 */

public interface StateContract {
    interface View extends BaseView<StateContract.Presenter> {
        void displayStateList(List<StateResponse.ResultBean> result);
    }

    interface Presenter extends BasePresenter {

    }
}
