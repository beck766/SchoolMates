package com.beck.helloschoolmate.model.repository;

import android.content.Context;

import com.beck.base.util.NetworkUtils;
import com.beck.helloschoolmate.model.http.ApiClient;
import com.beck.helloschoolmate.model.http.ApiConstants;
import com.beck.helloschoolmate.model.http.entity.register.RegisterCheckRequest;
import com.beck.helloschoolmate.model.http.entity.register.RegisterCheckoutResponse;
import com.beck.helloschoolmate.model.http.service.MatesService;

import io.reactivex.Emitter;
import io.reactivex.Observable;

/**
 * Created by beck on 2018/6/20.
 */

public class RegisterCheckoutRepository {

    public Observable<RegisterCheckoutResponse> checkoutAccount(Context context, RegisterCheckRequest registerCheckRequest) {

        if (!NetworkUtils.isNetworkConnected(context)) {
            return Observable.create(Emitter::onComplete);
        }

        Observable<RegisterCheckoutResponse> registerCheckoutResponseObservable = ApiClient.initMatesService(ApiConstants.MATE_HOST, MatesService.class).checkAccount(registerCheckRequest);

        assert registerCheckoutResponseObservable != null;

        return registerCheckoutResponseObservable;
    }
}
