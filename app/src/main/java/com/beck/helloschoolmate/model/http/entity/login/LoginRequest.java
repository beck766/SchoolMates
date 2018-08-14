package com.beck.helloschoolmate.model.http.entity.login;

/**
 * Created by beck on 2018/5/22.
 */

public class LoginRequest {

    /**
     * account : 15013809484
     * password : 123456
     */

    private String account;
    private String password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
