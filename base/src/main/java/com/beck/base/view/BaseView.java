package com.beck.base.view;

/**
 * view interface,所有View(此项目中的View主要是Fragment和自定义的ViewGroup)必须实现此接口
 */
public interface BaseView<T> {

    void requestError(String error);
    void setPresenter(T presenter);
    T getPresenter();
}
