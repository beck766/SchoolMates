package com.beck.helloschoolmate.model.repository;

import android.content.Context;
import android.util.Log;

import com.beck.base.util.NetworkUtils;
import com.beck.helloschoolmate.model.http.ApiClient;
import com.beck.helloschoolmate.model.http.ApiConstants;
import com.beck.helloschoolmate.model.http.entity.addfriend.AddFriendSendRequest;
import com.beck.helloschoolmate.model.http.entity.addfriend.AddFriendSendResponse;
import com.beck.helloschoolmate.model.http.service.MatesService;

import io.reactivex.Emitter;
import io.reactivex.Observable;

/**
 * Created by beck on 2018/6/5.
 */

public class AddFriSendRepository {
    private static final String TAG = "AddFriSendRepository";

    public Observable<AddFriendSendResponse> getAddFriResponse(Context context, String accessToken, AddFriendSendRequest request) {

        if (!NetworkUtils.isNetworkConnected(context)) {
            Log.i(TAG, "getLoginResponse: 网络异常");
            return Observable.create(Emitter::onComplete);
        }

        Observable<AddFriendSendResponse> addFriendSendResponseObservable = ApiClient.initMatesService(ApiConstants.MATE_HOST, MatesService.class).addFriendSend(accessToken, request);

        assert addFriendSendResponseObservable != null;

        return addFriendSendResponseObservable;
    }
}
