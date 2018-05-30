package com.beck.helloschoolmate.model.http.entity.user;

/**
 * Created by beck on 2018/5/29.
 */

public class VerfiyCodeRequest {

    /**
     * captcha : 892378
     * phoneNumber : 18270892378
     */

    private String captcha;
    private String phoneNumber;

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
