package com.beck.helloschoolmate.model.http.entity.register;

/**
 * Created by beck on 2018/5/30.
 */

public class RegisterRequest {


    /**
     * account : 15013809484
     * nickName : 林
     * password : 123456
     */

    private String account;
    private String nickName;
    private String password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
