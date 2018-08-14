package com.beck.helloschoolmate.model.repository;

import android.content.Context;

import com.beck.base.util.NetworkUtils;
import com.beck.helloschoolmate.model.http.ApiClient;
import com.beck.helloschoolmate.model.http.ApiConstants;
import com.beck.helloschoolmate.model.http.entity.state.StateRequest;
import com.beck.helloschoolmate.model.http.entity.state.StateResponse;
import com.beck.helloschoolmate.model.http.service.MatesService;

import io.reactivex.Emitter;
import io.reactivex.Observable;

/**
 * Created by beck on 2018/8/13.
 */

public class GetStateRepository {
    public Observable<StateResponse> getStateList(Context context, String userToken, StateRequest stateRequest) {

        if (!NetworkUtils.isNetworkConnected(context)) {
            return Observable.create(Emitter::onComplete);
        }

        Observable<StateResponse> stateResponseObservable = ApiClient.initMatesService(ApiConstants.MATE_HOST, MatesService.class).getState(userToken, stateRequest);

        assert stateResponseObservable != null;

        return stateResponseObservable;
    }
}
