package com.beck.helloschoolmate.model.repository;

import android.content.Context;
import android.util.Log;

import com.beck.base.util.NetworkUtils;
import com.beck.helloschoolmate.model.http.ApiClient;
import com.beck.helloschoolmate.model.http.ApiConstants;
import com.beck.helloschoolmate.model.http.entity.user.GetCodeRequest;
import com.beck.helloschoolmate.model.http.entity.user.GetCodeResponse;
import com.beck.helloschoolmate.model.http.entity.user.VerfiyCodeRequest;
import com.beck.helloschoolmate.model.http.entity.user.VerfiyCodeResponse;
import com.beck.helloschoolmate.model.http.service.MatesService;

import io.reactivex.Emitter;
import io.reactivex.Observable;

/**
 * Created by beck on 2018/5/29.
 */

public class RegisterCodeRepository {

    private static final String TAG = "RegisterCodeRepository";

    public Observable<GetCodeResponse> getCode(Context context, GetCodeRequest getCodeRequest) {
        Log.i(TAG, "getCode: ");
        if (!NetworkUtils.isNetworkConnected(context)) {
            Log.i(TAG, "getCode: 网络异常");
            return Observable.create(Emitter::onComplete);
        }

        Observable<GetCodeResponse> codeResponseObservable = ApiClient.initMatesService(ApiConstants.MATE_HOST, MatesService.class).getCode(getCodeRequest);

        assert codeResponseObservable != null;
        return codeResponseObservable;
    }

    public Observable<VerfiyCodeResponse> verfiyCode(Context context, String token, VerfiyCodeRequest verfiyCodeRequest) {

        if (!NetworkUtils.isNetworkConnected(context)) {
            Log.i(TAG, "verfiyCode: 网络异常");
            return Observable.create(Emitter::onComplete);
        }

        Observable<VerfiyCodeResponse> verfiyCodeResponseObservable = ApiClient.initMatesService(ApiConstants.MATE_HOST, MatesService.class).verfiyCode(token,verfiyCodeRequest);

        assert verfiyCodeResponseObservable != null;

        return verfiyCodeResponseObservable;
    }
}
