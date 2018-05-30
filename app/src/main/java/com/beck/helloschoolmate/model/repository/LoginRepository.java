package com.beck.helloschoolmate.model.repository;

import android.content.Context;
import android.util.Log;

import com.beck.base.util.NetworkUtils;
import com.beck.helloschoolmate.model.http.ApiClient;
import com.beck.helloschoolmate.model.http.ApiConstants;
import com.beck.helloschoolmate.model.http.entity.user.LoginRequest;
import com.beck.helloschoolmate.model.http.entity.user.LoginResponse;
import com.beck.helloschoolmate.model.http.service.MatesService;

import io.reactivex.Emitter;
import io.reactivex.Observable;

/**
 * Created by beck on 2018/5/22.
 */

public class LoginRepository {
    private static final String TAG = "LoginRepository";

    public Observable<LoginResponse> getLoginResponse(Context context, LoginRequest request) {

        if (!NetworkUtils.isNetworkConnected(context)) {
            Log.i(TAG, "getLoginResponse: 网络异常");
            return Observable.create(Emitter::onComplete);
        }

        Observable<LoginResponse> loginInfo = ApiClient.initMatesService(ApiConstants.MATE_HOST, MatesService.class).getLoginInfo(request);

        assert loginInfo != null;

        return loginInfo;
    }

}
