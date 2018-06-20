package com.beck.helloschoolmate.model.http.service;

import com.beck.helloschoolmate.model.http.entity.addfriend.AddFriSearchRequest;
import com.beck.helloschoolmate.model.http.entity.addfriend.AddFriSearchResponse;
import com.beck.helloschoolmate.model.http.entity.addfriend.AddFriendSendRequest;
import com.beck.helloschoolmate.model.http.entity.addfriend.AddFriendSendResponse;
import com.beck.helloschoolmate.model.http.entity.friend.FriendListRequest;
import com.beck.helloschoolmate.model.http.entity.friend.FriendResponse;
import com.beck.helloschoolmate.model.http.entity.friend.NewFriAgreeRequest;
import com.beck.helloschoolmate.model.http.entity.friend.NewFriAgreeResponse;
import com.beck.helloschoolmate.model.http.entity.friend.NewFriCheckResponse;
import com.beck.helloschoolmate.model.http.entity.login.LoginRequest;
import com.beck.helloschoolmate.model.http.entity.login.LoginResponse;
import com.beck.helloschoolmate.model.http.entity.register.GetCodeRequest;
import com.beck.helloschoolmate.model.http.entity.register.GetCodeResponse;
import com.beck.helloschoolmate.model.http.entity.register.RegisterCheckRequest;
import com.beck.helloschoolmate.model.http.entity.register.RegisterCheckoutResponse;
import com.beck.helloschoolmate.model.http.entity.register.RegisterRequest;
import com.beck.helloschoolmate.model.http.entity.register.RegisterResponse;
import com.beck.helloschoolmate.model.http.entity.register.VerfiyCodeRequest;
import com.beck.helloschoolmate.model.http.entity.register.VerfiyCodeResponse;
import com.beck.helloschoolmate.model.http.entity.userinfo.MyInfoResponse;

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
    @POST("user/checkout/captcha/")
    Observable<VerfiyCodeResponse> verfiyCode(@Query("accessToken") String accessToken, @Body VerfiyCodeRequest verfiyCodeRequest);

    /**
     * 验证账号是否存在
     *
     * @param registerCheckRequest
     * @return
     */
    @POST("user/checkout/account/")
    Observable<RegisterCheckoutResponse> checkAccount(@Body RegisterCheckRequest registerCheckRequest);

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
    Observable<NewFriCheckResponse> newFriendCheck(@Query("accessToken") String accessToken);

    /**
     * 获取好友列表
     *
     * @param accessToken
     * @param newFriAgreeRequest
     * @return
     */
    @POST("friend/request/agree/")
    Observable<NewFriAgreeResponse> newFriendAgree(@Query("accessToken") String accessToken, @Body NewFriAgreeRequest newFriAgreeRequest);

    /**
     * 查看分组好友列表
     *
     * @param accessToken
     * @param friendListRequest
     * @return
     */
    @POST("friend/list/friend_group/")
    Observable<FriendResponse> friendList(@Query("accessToken") String accessToken, @Body FriendListRequest friendListRequest);

    /**
     * 查看自己资料
     *
     * @param accessToken
     * @return
     */
    @POST("user/info/self/")
    Observable<MyInfoResponse> myInfo(@Query("accessToken") String accessToken);
}
