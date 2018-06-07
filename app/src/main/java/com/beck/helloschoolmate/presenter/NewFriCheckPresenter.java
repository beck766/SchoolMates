package com.beck.helloschoolmate.presenter;

import android.content.Context;
import android.util.Log;

import com.beck.helloschoolmate.contract.NewFriCheckContract;
import com.beck.helloschoolmate.model.http.entity.friend.NewFriendResponse;
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
                .subscribe(new DisposableObserver<NewFriendResponse>() {
                    @Override
                    public void onNext(NewFriendResponse newFriendResponse) {
                        if (newFriendResponse != null && newFriendResponse.isSuccess()) {
                            view.requestSuccess(newFriendResponse);
                        } else {
                            view.requestError("请求出错");
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
