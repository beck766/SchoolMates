package com.beck.base.presenter;

/**
 * presenter interface,所有Presenter必须实现此接口
 */
public interface BasePresenter {

    void subscribe();

    void refresh();

    void unSubscribe();
}
