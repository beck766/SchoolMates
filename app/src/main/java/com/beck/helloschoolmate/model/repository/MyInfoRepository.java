package com.beck.helloschoolmate.model.repository;

import android.content.Context;

import com.beck.base.util.NetworkUtils;
import com.beck.helloschoolmate.model.http.ApiClient;
import com.beck.helloschoolmate.model.http.ApiConstants;
import com.beck.helloschoolmate.model.http.entity.userinfo.MyInfoResponse;
import com.beck.helloschoolmate.model.http.service.MatesService;

import io.reactivex.Emitter;
import io.reactivex.Observable;

/**
 * Created by beck on 2018/6/19.
 */

public class MyInfoRepository {

    public Observable<MyInfoResponse> getMyInfo(Context context, String userToken) {

        if (!NetworkUtils.isNetworkConnected(context)) {
            return Observable.create(Emitter::onComplete);
        }

        Observable<MyInfoResponse> myInfoResponseObservable = ApiClient.initMatesService(ApiConstants.MATE_HOST, MatesService.class).myInfo(userToken);

        assert myInfoResponseObservable != null;

        return myInfoResponseObservable;
    }
}
