package com.beck.helloschoolmate.presenter;

import android.content.Context;
import android.util.Log;

import com.beck.helloschoolmate.contract.FriendListContract;
import com.beck.helloschoolmate.model.http.entity.friend.FriendListRequest;
import com.beck.helloschoolmate.model.http.entity.friend.FriendResponse;
import com.beck.helloschoolmate.model.repository.FriendListRepository;
import com.beck.helloschoolmate.util.UserManager;

import java.net.SocketTimeoutException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by beck on 2018/6/11.
 */

public class FriendListPresenter implements FriendListContract.Presenter {

    private static final String TAG = "FriendListPresenter";
    private FriendListContract.View view;
    private Context context;

    public FriendListPresenter(Context context, FriendListContract.View view) {
        this.view = view;
        this.context = context;
        view.setPresenter(this);
    }


    @Override
    public void subscribe() {
        String userToken = UserManager.getInstance().getUserToken(context);
        FriendListRequest friendListRequest = new FriendListRequest();
        friendListRequest.setFriendGroupId(0);
        new FriendListRepository().getFriendList(context, userToken, friendListRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<FriendResponse>() {
                    @Override
                    public void onNext(FriendResponse friendResponse) {
                        if (friendResponse.isSuccess()) {
                            List<FriendResponse.ResultBean> result = friendResponse.getResult();
                            view.displayFriList(result);
                        }else {
                            view.requestError(friendResponse.getErrorMsg());
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
