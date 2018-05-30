package com.beck.helloschoolmate.model.http.service;

import com.beck.helloschoolmate.model.http.entity.user.GetCodeRequest;
import com.beck.helloschoolmate.model.http.entity.user.GetCodeResponse;
import com.beck.helloschoolmate.model.http.entity.user.LoginRequest;
import com.beck.helloschoolmate.model.http.entity.user.LoginResponse;
import com.beck.helloschoolmate.model.http.entity.user.RegisterRequest;
import com.beck.helloschoolmate.model.http.entity.user.RegisterResponse;
import com.beck.helloschoolmate.model.http.entity.user.VerfiyCodeRequest;
import com.beck.helloschoolmate.model.http.entity.user.VerfiyCodeResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by beck on 2018/5/22.
 */

public interface MatesService {

    /**
     * 登录
     *
     * @param loginRequest
     * @return
     */
    @POST("user/login/")
    Observable<LoginResponse> getLoginInfo(@Body LoginRequest loginRequest);

    /**
     * 获取验证码
     *
     * @param getCodeRequest
     * @return
     */
    @POST("user/captcha/send/")
    Observable<GetCodeResponse> getCode(@Body GetCodeRequest getCodeRequest);

    /**
     * 检验验证码
     *
     * @param verfiyCodeRequest
     * @return
     */
    @POST("user/captcha/checkout/")
    Observable<VerfiyCodeResponse> verfiyCode(@Body VerfiyCodeRequest verfiyCodeRequest);

    /**
     * 完成注册
     *
     * @param accessToken
     * @param registerRequest
     * @return
     */
    @POST("user/register/")
    Observable<RegisterResponse> register(@Query("accessToken") String accessToken, @Body RegisterRequest registerRequest);
}
