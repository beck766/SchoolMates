package com.beck.helloschoolmate.presenter;

import android.content.Context;
import android.util.Log;

import com.beck.helloschoolmate.contract.NewFriCheckContract;
import com.beck.helloschoolmate.model.http.entity.friend.NewFriCheckResponse;
import com.beck.helloschoolmate.model.repository.NewFriCheckRepository;
import com.beck.helloschoolmate.util.UserManager;

import java.net.SocketTimeoutException;
import java.util.concurrent.TimeoutException;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by beck on 2018/6/7.
 */

public class NewFriCheckPresenter implements NewFriCheckContract.Presenter {
    private static final String TAG = "AddFriSearchPresenter";
    private NewFriCheckContract.View view;
    private Context context;

    public NewFriCheckPresenter(Context context, NewFriCheckContract.View view) {
        this.view = view;
        this.context = context;
        view.setPresenter(this);
    }

    @Override
    public void subscribe() {
        String userToken = UserManager.getInstance().getUserToken(context);
        new NewFriCheckRepository().getNewFriResponse(context, userToken)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<NewFriCheckResponse>() {
                    @Override
                    public void onNext(NewFriCheckResponse newFriCheckResponse) {
                        if (newFriCheckResponse != null && newFriCheckResponse.isSuccess()) {
                            view.requestSuccess(newFriCheckResponse);
                        } else {
                            assert newFriCheckResponse != null;
                            view.requestError(newFriCheckResponse.getErrorMsg());
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
