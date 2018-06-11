package com.beck.helloschoolmate.model.repository;

import android.content.Context;

import com.beck.base.util.NetworkUtils;
import com.beck.helloschoolmate.model.http.ApiClient;
import com.beck.helloschoolmate.model.http.ApiConstants;
import com.beck.helloschoolmate.model.http.entity.friend.FriendListRequest;
import com.beck.helloschoolmate.model.http.entity.friend.FriendResponse;
import com.beck.helloschoolmate.model.http.service.MatesService;

import io.reactivex.Emitter;
import io.reactivex.Observable;

/**
 * Created by beck on 2018/6/11.
 */

public class FriendListRepository {
    public Observable<FriendResponse> getFriendList(Context context, String userToken, FriendListRequest friendListRequest) {

        if (!NetworkUtils.isNetworkConnected(context)) {
            return Observable.create(Emitter::onComplete);
        }

        Observable<FriendResponse> friendResponseObservable = ApiClient.initMatesService(ApiConstants.MATE_HOST, MatesService.class).friendList(userToken, friendListRequest);

        assert friendResponseObservable != null;

        return friendResponseObservable;
    }
}
