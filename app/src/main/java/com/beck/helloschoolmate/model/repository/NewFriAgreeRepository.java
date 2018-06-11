package com.beck.helloschoolmate.model.repository;

import android.content.Context;

import com.beck.base.util.NetworkUtils;
import com.beck.helloschoolmate.model.http.ApiClient;
import com.beck.helloschoolmate.model.http.ApiConstants;
import com.beck.helloschoolmate.model.http.entity.friend.NewFriAgreeRequest;
import com.beck.helloschoolmate.model.http.entity.friend.NewFriAgreeResponse;
import com.beck.helloschoolmate.model.http.service.MatesService;

import io.reactivex.Emitter;
import io.reactivex.Observable;

/**
 * Created by beck on 2018/6/11.
 */

public class NewFriAgreeRepository {

    public Observable<NewFriAgreeResponse> getNewFriAgreeResponse(Context context, String userToken, NewFriAgreeRequest newFriAgreeRequest) {

        if (!NetworkUtils.isNetworkConnected(context)) {
            return Observable.create(Emitter::onComplete);
        }

        Observable<NewFriAgreeResponse> newFriAgreeResponseObservable = ApiClient.initMatesService(ApiConstants.MATE_HOST, MatesService.class).newFriendAgree(userToken, newFriAgreeRequest);

        assert newFriAgreeResponseObservable != null;

        return newFriAgreeResponseObservable;
    }
}
