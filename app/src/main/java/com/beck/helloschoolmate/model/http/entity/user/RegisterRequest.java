package com.beck.helloschoolmate.model.http.entity.user;

/**
 * Created by beck on 2018/5/30.
 */

public class RegisterRequest {

    /**
     * password : string
     * phoneNumber : 18270892378
     */

    private String password;
    private String phoneNumber;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
