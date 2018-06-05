package com.beck.helloschoolmate.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.beck.helloschoolmate.model.preference.entity.LoginUserInfo;

/**
 * Created by beck on 2018/5/22.
 */

public class UserManager {
    private static UserManager instance;

    private UserManager() {
    }

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    /**
     * 保存自动登录的用户信息
     */
    public void saveLoginUserInfo(Context context, String username, String password, String channlId) {
        SharedPreferences sp = context.getSharedPreferences("LoginUserInfo", Context.MODE_PRIVATE);//Context.MODE_PRIVATE表示SharePrefences的数据只有自己应用程序能访问。
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("USER_NUMBER", username);
        editor.putString("PASSWORD", password);
        editor.apply();
    }

    /**
     * 保存自动登录的用户信息
     */
    public void saveLoginUserInfo(Context context, String username, String token) {
        SharedPreferences sp = context.getSharedPreferences("LoginUserInfo", Context.MODE_PRIVATE);//Context.MODE_PRIVATE表示SharePrefences的数据只有自己应用程序能访问。
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("USER_NUMBER", username);
        editor.putString("USER_TOKEN", token);
        editor.apply();
    }

    /**
     * 保存注册时候得到的Token
     */
    public void saveRegisterInfo(Context context, String token) {
        SharedPreferences sp = context.getSharedPreferences("RegisterInfo", Context.MODE_PRIVATE);//Context.MODE_PRIVATE表示SharePrefences的数据只有自己应用程序能访问。
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("TOKEN", token);
        editor.apply();
    }

    public void clearLoginInfo(Context context) {
        SharedPreferences sp = context.getSharedPreferences("LoginUserInfo", Context.MODE_PRIVATE);//Context.MODE_PRIVATE表示SharePrefences的数据只有自己应用程序能访问。
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.apply();
    }

    /**
     * 获取用户信息model
     */
    public LoginUserInfo getLoginUserInfo(Context context) {
        SharedPreferences sp = context.getSharedPreferences("LoginUserInfo", Context.MODE_PRIVATE);
        LoginUserInfo LoginUserInfo = new LoginUserInfo();
        LoginUserInfo.setUserNumber(sp.getString("USER_NUMBER", ""));
        LoginUserInfo.setPassword(sp.getString("PASSWORD", ""));
        return LoginUserInfo;
    }

    public String getUserToken(Context context) {
        SharedPreferences sp = context.getSharedPreferences("LoginUserInfo", Context.MODE_PRIVATE);
        String user_token = sp.getString("USER_TOKEN", "");
        return user_token;
    }

    public String getRegisterToken(Context context) {
        SharedPreferences sp = context.getSharedPreferences("RegisterInfo", Context.MODE_PRIVATE);
        String user_token = sp.getString("TOKEN", "");
        return user_token;
    }
    /**
     * LoginUserInfo中是否有数据
     */
    public boolean hasLoginUserInfo(Context context) {
        LoginUserInfo LoginUserInfo = getLoginUserInfo(context);
        if (LoginUserInfo != null) {
            if ((!TextUtils.isEmpty(LoginUserInfo.getUserNumber())) && (!TextUtils.isEmpty(LoginUserInfo.getPassword()))) {//有数据
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

}
