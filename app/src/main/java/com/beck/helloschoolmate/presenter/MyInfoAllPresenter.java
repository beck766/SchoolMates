package com.beck.helloschoolmate.presenter;

import android.content.Context;
import android.util.Log;

import com.beck.helloschoolmate.contract.MyInfoAllContract;
import com.beck.helloschoolmate.model.http.entity.userinfo.MyInfoResponse;
import com.beck.helloschoolmate.model.repository.MyInfoRepository;
import com.beck.helloschoolmate.util.UserManager;

import java.net.SocketTimeoutException;
import java.util.concurrent.TimeoutException;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by beck on 2018/6/15.
 */

public class MyInfoAllPresenter implements MyInfoAllContract.Presenter {

    private static final String TAG = "MyInfoAllPresenter";
    private MyInfoAllContract.View view;
    private Context context;
    private DisposableObserver<MyInfoResponse> disposableObserver;

    public MyInfoAllPresenter(Context context, MyInfoAllContract.View view) {
        this.view = view;
        this.context = context;
        view.setPresenter(this);
    }

    @Override
    public void subscribe() {
        String userToken = UserManager.getInstance().getUserToken(context);
        if (disposableObserver != null) {
            disposableObserver.dispose();
        }
        disposableObserver = new MyInfoRepository().getMyInfo(context, userToken)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<MyInfoResponse>() {
                    @Override
                    public void onNext(MyInfoResponse myInfoResponse) {
                        if (myInfoResponse.isSuccess()) {
                            view.displayMyInfo(myInfoResponse.getResult());
                        }else {
                            view.requestError(myInfoResponse.getErrorMsg());
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
    public void refresh() {

    }

    @Override
    public void unSubscribe() {

    }
}
