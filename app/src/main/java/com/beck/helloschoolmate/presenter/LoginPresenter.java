package com.beck.helloschoolmate.presenter;

import android.content.Context;
import android.util.Log;

import com.beck.helloschoolmate.contract.LoginContract;
import com.beck.helloschoolmate.model.http.entity.login.LoginRequest;
import com.beck.helloschoolmate.model.http.entity.login.LoginResponse;
import com.beck.helloschoolmate.model.preference.entity.LoginUserInfo;
import com.beck.helloschoolmate.model.repository.LoginRepository;
import com.beck.helloschoolmate.util.UserManager;

import java.net.SocketTimeoutException;
import java.util.concurrent.TimeoutException;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by beck on 2018/5/22.
 * LoginPresenter
 */

public class LoginPresenter implements LoginContract.Presenter {

    private static final String TAG = "LoginPresenter";
    private LoginContract.View view;
    private Context context;

    public LoginPresenter(Context context, LoginContract.View view) {
        this.view = view;
        this.context = context;
        view.setPresenter(this);
    }

    @Override
    public void subscribe() {
        LoginUserInfo loginUserInfo = UserManager.getInstance().getLoginUserInfo(context);
        setData(loginUserInfo);
    }

    @Override
    public void refresh() {

    }

    @Override
    public void unSubscribe() {

    }

    @Override
    public void setData(LoginUserInfo loginUserInfo) {
        view.InitUserInfo(loginUserInfo);
        Log.i(TAG, "setData: " + loginUserInfo.getUserNumber());
    }

    @Override
    public void getUerInfo(LoginRequest loginRequest) {
        new LoginRepository().getLoginResponse(context, loginRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<LoginResponse>() {
                    @Override
                    public void onNext(LoginResponse loginResponse) {
                        Log.i(TAG, "onNext: " + loginResponse);
                        if (loginResponse.isSuccess()){
                            view.loginSuccess(loginResponse);
                        }else {
                            view.requestError(loginResponse.getErrorMsg());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError: " + e.toString());
                        if (e instanceof TimeoutException) {
                            view.requestError("请求超时");
                        } else if (e instanceof SocketTimeoutException) {
                            view.requestError("请求超时");
                        } else {
                            view.requestError("服务器异常");
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
