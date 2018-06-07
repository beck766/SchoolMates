package com.beck.helloschoolmate.presenter;

import android.content.Context;
import android.util.Log;

import com.beck.helloschoolmate.contract.AddFriSearchContract;
import com.beck.helloschoolmate.model.http.entity.addfriend.AddFriSearchRequest;
import com.beck.helloschoolmate.model.http.entity.addfriend.AddFriSearchResponse;
import com.beck.helloschoolmate.model.repository.AddFriSearchRepository;
import com.beck.helloschoolmate.util.UserManager;

import java.net.SocketTimeoutException;
import java.util.concurrent.TimeoutException;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by beck on 2018/6/2.
 */

public class AddFriSearchPresenter implements AddFriSearchContract.Presenter {

    private static final String TAG = "AddFriSearchPresenter";
    private AddFriSearchContract.View view;
    private Context context;

    public AddFriSearchPresenter(Context context, AddFriSearchContract.View view) {
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
    public void search(AddFriSearchRequest addFriSearchRequest) {
        String userToken = UserManager.getInstance().getUserToken(context);
        new AddFriSearchRepository().getAddFriResponse(context, userToken, addFriSearchRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<AddFriSearchResponse>() {
                    @Override
                    public void onNext(AddFriSearchResponse addFriSearchResponse) {
                        Log.i(TAG, "onNext: " + addFriSearchResponse.isSuccess());
                        if (addFriSearchResponse.isSuccess()) {
                            view.searchSuccess(addFriSearchResponse);
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
