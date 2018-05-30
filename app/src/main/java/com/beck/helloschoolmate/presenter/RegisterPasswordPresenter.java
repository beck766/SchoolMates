package com.beck.helloschoolmate.presenter;

import android.content.Context;
import android.util.Log;

import com.beck.helloschoolmate.contract.RegisterPasswordContract;
import com.beck.helloschoolmate.model.http.entity.user.RegisterRequest;
import com.beck.helloschoolmate.model.http.entity.user.RegisterResponse;
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
                            view.RequestError("注册失败");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError: " + e.toString());
                        if (e instanceof TimeoutException) {
                            view.RequestError("请求超时");
                        } else if (e instanceof SocketTimeoutException) {
                            view.RequestError("请求超时");
                        } else {
                            view.RequestError("服务器异常");
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
