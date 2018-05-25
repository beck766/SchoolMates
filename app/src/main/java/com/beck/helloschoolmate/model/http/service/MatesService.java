package com.beck.helloschoolmate.model.http.service;

import com.beck.helloschoolmate.model.http.entity.user.LoginRequest;
import com.beck.helloschoolmate.model.http.entity.user.LoginResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by beck on 2018/5/22.
 */

public interface MatesService {

    /**
     * 登录
     *
     * @param loginRequest LoginRequest
     * @return LoginResponse
     */
    @POST("user/login/")
    Observable<LoginResponse> getLoginInfo(@Body LoginRequest loginRequest);

}
