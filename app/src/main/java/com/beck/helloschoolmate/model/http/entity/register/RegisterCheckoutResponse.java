package com.beck.helloschoolmate.model.http.entity.register;

/**
 * Created by beck on 2018/6/20.
 */

public class RegisterCheckoutResponse {

    /**
     * success : false
     * errorMsg : 呀，账号已经被别人抢了，再换一个吧
     * errorCode : -1
     */

    private boolean success;
    private String errorMsg;
    private int errorCode;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
