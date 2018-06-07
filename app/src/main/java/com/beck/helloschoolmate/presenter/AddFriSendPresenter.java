package com.beck.helloschoolmate.presenter;

import android.content.Context;
import android.util.Log;

import com.beck.helloschoolmate.contract.AddFriSendContract;
import com.beck.helloschoolmate.model.http.entity.addfriend.AddFriendSendRequest;
import com.beck.helloschoolmate.model.http.entity.addfriend.AddFriendSendResponse;
import com.beck.helloschoolmate.model.repository.AddFriSendRepository;
import com.beck.helloschoolmate.util.UserManager;

import java.net.SocketTimeoutException;
import java.util.concurrent.TimeoutException;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by beck on 2018/6/5.
 */

public class AddFriSendPresenter implements AddFriSendContract.Presenter{
    private static final String TAG = "AddFriSendPresenter";
    private AddFriSendContract.View view;
    private Context context;

    public AddFriSendPresenter(Context context, AddFriSendContract.View view) {
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
    public void send(AddFriendSendRequest addFriendSendRequest) {
        String userToken = UserManager.getInstance().getUserToken(context);
        new AddFriSendRepository().getAddFriResponse(context,userToken,addFriendSendRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<AddFriendSendResponse>() {
                    @Override
                    public void onNext(AddFriendSendResponse addFriendSendResponse) {
                        Log.i(TAG, "onNext: " + addFriendSendResponse.isSuccess());
                        if (addFriendSendResponse.isSuccess()) {
                            view.searchSuccess();
                        } else {
                            view.requestError("账号不存在");
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
