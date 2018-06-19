package com.beck.helloschoolmate.model.http.entity.register;

/**
 * Created by beck on 2018/5/29.
 */

public class GetCodeRequest {

    /**
     * phoneNumber : 18270889760
     */

    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
