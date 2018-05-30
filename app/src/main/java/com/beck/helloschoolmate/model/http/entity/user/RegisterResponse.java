package com.beck.helloschoolmate.model.http.entity.user;

/**
 * Created by beck on 2018/5/30.
 */

public class RegisterResponse {

    /**
     * success : true
     * errorMsg :
     * errorCode : 0
     * resultCount : null
     * errorCount : null
     * result : {"userToken":"eyJ0eXAiOiIiLCJhbGciOiJIUzI1NiIsImNsZyI6IiJ9.eyJzdWIiOiIiLCJhdWQiOiIiLCJleHAiOjE1Mjc2NDk4NjMsInVzZXJJZCI6NCwiaWF0IjoxNTI3NjQ2MjYzfQ.VWKwZBfRDhn6mf-BBZDU4UQzuGVJsKMv2ex_zlyiNis","thumbHeadImg":null,"userId":4}
     * results : null
     */

    private boolean success;
    private String errorMsg;
    private int errorCode;
    private Object resultCount;
    private Object errorCount;
    private ResultBean result;
    private Object results;

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

    public Object getResultCount() {
        return resultCount;
    }

    public void setResultCount(Object resultCount) {
        this.resultCount = resultCount;
    }

    public Object getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(Object errorCount) {
        this.errorCount = errorCount;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public Object getResults() {
        return results;
    }

    public void setResults(Object results) {
        this.results = results;
    }

    public static class ResultBean {
        /**
         * userToken : eyJ0eXAiOiIiLCJhbGciOiJIUzI1NiIsImNsZyI6IiJ9.eyJzdWIiOiIiLCJhdWQiOiIiLCJleHAiOjE1Mjc2NDk4NjMsInVzZXJJZCI6NCwiaWF0IjoxNTI3NjQ2MjYzfQ.VWKwZBfRDhn6mf-BBZDU4UQzuGVJsKMv2ex_zlyiNis
         * thumbHeadImg : null
         * userId : 4
         */

        private String userToken;
        private Object thumbHeadImg;
        private int userId;

        public String getUserToken() {
            return userToken;
        }

        public void setUserToken(String userToken) {
            this.userToken = userToken;
        }

        public Object getThumbHeadImg() {
            return thumbHeadImg;
        }

        public void setThumbHeadImg(Object thumbHeadImg) {
            this.thumbHeadImg = thumbHeadImg;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }
}
