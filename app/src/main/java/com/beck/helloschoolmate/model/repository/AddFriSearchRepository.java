package com.beck.helloschoolmate.model.repository;

import android.content.Context;
import android.util.Log;

import com.beck.base.util.NetworkUtils;
import com.beck.helloschoolmate.model.http.ApiClient;
import com.beck.helloschoolmate.model.http.ApiConstants;
import com.beck.helloschoolmate.model.http.entity.addfriend.AddFriSearchRequest;
import com.beck.helloschoolmate.model.http.entity.addfriend.AddFriSearchResponse;
import com.beck.helloschoolmate.model.http.service.MatesService;

import io.reactivex.Emitter;
import io.reactivex.Observable;

/**
 * Created by beck on 2018/6/2.
 */

public class AddFriSearchRepository {

    private static final String TAG = "AddFriSearchRepository";

    public Observable<AddFriSearchResponse> getAddFriResponse(Context context, String accessToken, AddFriSearchRequest request) {

        if (!NetworkUtils.isNetworkConnected(context)) {
            Log.i(TAG, "getLoginResponse: 网络异常");
            return Observable.create(Emitter::onComplete);
        }

        Observable<AddFriSearchResponse> addFriSearchResponseObservable = ApiClient.initMatesService(ApiConstants.MATE_HOST, MatesService.class).addFriendSearch(accessToken, request);

        assert addFriSearchResponseObservable != null;

        return addFriSearchResponseObservable;
    }
}
