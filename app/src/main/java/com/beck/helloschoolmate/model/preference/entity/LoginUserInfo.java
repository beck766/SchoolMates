package com.beck.helloschoolmate.model.preference.entity;

/**
 * Created by beck on 2018/5/25.
 */

public class LoginUserInfo {

    /**
     * 用户名
     */
    private String userNumber;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机唯一标识ID
     */
    private String channlId;

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getChannlId() {
        return channlId;
    }

    public void setChannlId(String channlId) {
        this.channlId = channlId;
    }
}
