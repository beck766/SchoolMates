package com.beck.helloschoolmate.model.repository;

import android.content.Context;

import com.beck.base.util.NetworkUtils;
import com.beck.helloschoolmate.model.http.ApiClient;
import com.beck.helloschoolmate.model.http.ApiConstants;
import com.beck.helloschoolmate.model.http.entity.friend.NewFriCheckResponse;
import com.beck.helloschoolmate.model.http.service.MatesService;

import io.reactivex.Emitter;
import io.reactivex.Observable;

/**
 * Created by beck on 2018/6/7.
 */

public class NewFriCheckRepository {

    public Observable<NewFriCheckResponse> getNewFriResponse(Context context, String userToken) {

        if (!NetworkUtils.isNetworkConnected(context)) {
            return Observable.create(Emitter::onComplete);
        }

        Observable<NewFriCheckResponse> newFriendResponseObservable = ApiClient.initMatesService(ApiConstants.MATE_HOST, MatesService.class).newFriendCheck(userToken);

        assert newFriendResponseObservable != null;

        return newFriendResponseObservable;
    }
}
