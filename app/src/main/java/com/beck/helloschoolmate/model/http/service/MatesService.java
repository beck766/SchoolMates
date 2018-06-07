package com.beck.helloschoolmate.model.http.service;

import com.beck.helloschoolmate.model.http.entity.addfriend.AddFriSearchRequest;
import com.beck.helloschoolmate.model.http.entity.addfriend.AddFriSearchResponse;
import com.beck.helloschoolmate.model.http.entity.addfriend.AddFriendSendRequest;
import com.beck.helloschoolmate.model.http.entity.addfriend.AddFriendSendResponse;
import com.beck.helloschoolmate.model.http.entity.friend.NewFriendResponse;
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
     * @param accessToken
     * @param verfiyCodeRequest
     * @return
     */
    @POST("user/captcha/checkout/")
    Observable<VerfiyCodeResponse> verfiyCode(@Query("accessToken") String accessToken, @Body VerfiyCodeRequest verfiyCodeRequest);

    /**
     * 完成注册
     *
     * @param accessToken
     * @param registerRequest
     * @return
     */
    @POST("user/register/")
    Observable<RegisterResponse> register(@Query("accessToken") String accessToken, @Body RegisterRequest registerRequest);

    /**
     * 查找好友
     *
     * @param accessToken
     * @param addFriSearchRequest
     * @return
     */
    @POST("user/search/")
    Observable<AddFriSearchResponse> addFriendSearch(@Query("accessToken") String accessToken, @Body AddFriSearchRequest addFriSearchRequest);

    /**
     * 添加好友
     *
     * @param accessToken
     * @param addFriendSendRequest
     * @return
     */
    @POST("friend/request/add/")
    Observable<AddFriendSendResponse> addFriendSend(@Query("accessToken") String accessToken, @Body AddFriendSendRequest addFriendSendRequest);

    /**
     * 查看新好友
     *
     * @param accessToken
     * @return
     */
    @POST("friend/list/request/")
    Observable<NewFriendResponse> newFriendCheck(@Query("accessToken") String accessToken);
}
