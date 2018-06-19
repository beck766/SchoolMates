package com.beck.helloschoolmate.model.repository;

import android.content.Context;
import android.util.Log;

import com.beck.base.util.NetworkUtils;
import com.beck.helloschoolmate.model.http.ApiClient;
import com.beck.helloschoolmate.model.http.ApiConstants;
import com.beck.helloschoolmate.model.http.entity.register.RegisterRequest;
import com.beck.helloschoolmate.model.http.entity.register.RegisterResponse;
import com.beck.helloschoolmate.model.http.service.MatesService;

import io.reactivex.Emitter;
import io.reactivex.Observable;

/**
 * Created by beck on 2018/5/30.
 */

public class RegisterCompleteRepository {

    private static final String TAG = "RegisterCompleteReposit";

    public Observable<RegisterResponse> registerComplete(Context context, String accessToken, RegisterRequest registerRequest) {

        if (!NetworkUtils.isNetworkConnected(context)) {
            Log.i(TAG, "registerComplete: 网络异常");
            return Observable.create(Emitter::onComplete);
        }

        Observable<RegisterResponse> responseObservable = ApiClient.initMatesService(ApiConstants.MATE_HOST, MatesService.class).register(accessToken, registerRequest);

        assert responseObservable != null;
        return responseObservable;
    }
}
