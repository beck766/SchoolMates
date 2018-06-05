package com.beck.helloschoolmate.model.http.entity.user;

/**
 * Created by beck on 2018/5/29.
 */

public class VerfiyCodeRequest {

    /**
     * captcha : 892378
     */

    private String captcha;

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
