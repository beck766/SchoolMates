package com.beck.helloschoolmate.model.http.entity.user;

/**
 * Created by beck on 2018/5/22.
 */

public class LoginRequest {

    /**
     * phoneNumber : 18270889760
     * password : 123456
     * captcha :
     * loginType : 0
     */

    private String phoneNumber;
    private String password;
    private String captcha;
    private int loginType;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public int getLoginType() {
        return loginType;
    }

    public void setLoginType(int loginType) {
        this.loginType = loginType;
    }
}
