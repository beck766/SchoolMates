package com.beck.helloschoolmate.presenter;

import android.content.Context;
import android.util.Log;

import com.beck.helloschoolmate.contract.RegisterPasswordContract;
import com.beck.helloschoolmate.model.http.entity.register.RegisterCheckRequest;
import com.beck.helloschoolmate.model.http.entity.register.RegisterCheckoutResponse;
import com.beck.helloschoolmate.model.http.entity.register.RegisterRequest;
import com.beck.helloschoolmate.model.http.entity.register.RegisterResponse;
import com.beck.helloschoolmate.model.repository.RegisterCheckoutRepository;
import com.beck.helloschoolmate.model.repository.RegisterCompleteRepository;

import java.net.SocketTimeoutException;
import java.util.concurrent.TimeoutException;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by beck on 2018/5/30.
 */

public class RegisterPasswordPresenter implements RegisterPasswordContract.Presenter {

    private static final String TAG = "RegisterPasswordPresent";
    private RegisterPasswordContract.View view;
    private Context context;
    private DisposableObserver<RegisterCheckoutResponse> disposableObserver;

    public RegisterPasswordPresenter(Context context, RegisterPasswordContract.View view) {
        this.view = view;
        this.context = context;
        view.setPresenter(this);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void refresh() {

    }

    @Override
    public void unSubscribe() {

    }

    @Override
    public void register(String accessToken, RegisterRequest registerRequest) {
        Log.i(TAG, "register: "+registerRequest.getPassword());
        new RegisterCompleteRepository().registerComplete(context, accessToken, registerRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<RegisterResponse>() {
                    @Override
                    public void onNext(RegisterResponse registerResponse) {
                        Log.i(TAG, "onNext: 注册是否成功：" + registerResponse.isSuccess());
                        if (registerResponse.isSuccess()) {
                            view.registerSuccess();
                        } else {
                            view.requestError(registerResponse.getErrorMsg());
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

    @Override
    public void checkoutAccount(RegisterCheckRequest registerCheckRequest) {
        if (disposableObserver != null) {
            disposableObserver.dispose();
        }
        disposableObserver = new RegisterCheckoutRepository().checkoutAccount(context, registerCheckRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<RegisterCheckoutResponse>() {
                    @Override
                    public void onNext(RegisterCheckoutResponse registerCheckoutResponse) {
                        Log.i(TAG, "onNext: 校验账号是否成功：" + registerCheckoutResponse.isSuccess());
                        if (registerCheckoutResponse.isSuccess()) {
                            view.checkDisplay("该账号可以使用！");
                        } else {
                            view.checkDisplayFalse(registerCheckoutResponse.getErrorMsg());
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
