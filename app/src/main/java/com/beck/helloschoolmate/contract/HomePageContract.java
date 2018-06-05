package com.beck.helloschoolmate.contract;

import com.beck.base.presenter.BasePresenter;
import com.beck.base.view.BaseView;

/**
 * Created by beck on 2018/5/31.
 */

public interface HomePageContract {
    interface View extends BaseView<HomePageContract.Presenter>{

    }
    interface Presenter extends BasePresenter{

    }
}
