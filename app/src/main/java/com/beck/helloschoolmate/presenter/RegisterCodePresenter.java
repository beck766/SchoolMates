package com.beck.helloschoolmate.presenter;

import android.content.Context;
import android.util.Log;

import com.beck.helloschoolmate.contract.RegisterCodeContract;
import com.beck.helloschoolmate.model.http.entity.user.GetCodeRequest;
import com.beck.helloschoolmate.model.http.entity.user.GetCodeResponse;
import com.beck.helloschoolmate.model.http.entity.user.VerfiyCodeRequest;
import com.beck.helloschoolmate.model.http.entity.user.VerfiyCodeResponse;
import com.beck.helloschoolmate.model.repository.RegisterCodeRepository;
import com.beck.helloschoolmate.util.UserManager;

import java.net.SocketTimeoutException;
import java.util.concurrent.TimeoutException;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by beck on 2018/5/29.
 */

public class RegisterCodePresenter implements RegisterCodeContract.Presenter {

    private static final String TAG = "RegisterCodePresenter";
    private RegisterCodeContract.View view;
    private Context context;

    public RegisterCodePresenter(Context context, RegisterCodeContract.View view) {
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
    public void getVerfiyCode(GetCodeRequest getCodeRequest) {
        Log.i(TAG, "getVerfiyCode: " + getCodeRequest.getPhoneNumber());
        new RegisterCodeRepository().getCode(context, getCodeRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<GetCodeResponse>() {
                    @Override
                    public void onNext(GetCodeResponse getCodeResponse) {
                        boolean isSuccess = getCodeResponse.isSuccess();
                        Log.i(TAG, "onNext: 是否成功=" + isSuccess);
                        if (isSuccess) {
                            String userToken = getCodeResponse.getResult().getUserToken();
                            UserManager.getInstance().saveRegisterInfo(context, userToken);
                            Log.i(TAG, "onNext: "+userToken);
                            view.getCodeSuccess(true);
                        } else {
                            view.requestError(false + "");
                            Log.i(TAG, "onNext: 注册失败");
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
    public void verfiyCode(VerfiyCodeRequest verfiyCodeRequest) {
        String userToken = UserManager.getInstance().getRegisterToken(context);
        Log.i(TAG, "verfiyCode: "+userToken);
        new RegisterCodeRepository().verfiyCode(context, userToken, verfiyCodeRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<VerfiyCodeResponse>() {
                    @Override
                    public void onNext(VerfiyCodeResponse verfiyCodeResponse) {
                        Log.i(TAG, "onNext: 是否成功：" + verfiyCodeResponse.isSuccess());
                        if (verfiyCodeResponse.isSuccess()) {
                            view.verfiySussess(userToken);
                        } else {
                            view.requestError("验证码错误");
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
