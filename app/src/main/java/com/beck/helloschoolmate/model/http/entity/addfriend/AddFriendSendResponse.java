package com.beck.helloschoolmate.model.http.entity.addfriend;

/**
 * Created by beck on 2018/5/31.
 */

public class AddFriendSendResponse {

    /**
     * success : true
     * errorMsg :
     * errorCode : 0
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
