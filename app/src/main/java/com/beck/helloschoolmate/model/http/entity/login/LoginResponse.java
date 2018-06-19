package com.beck.helloschoolmate.model.http.entity.login;

/**
 * Created by beck on 2018/5/22.
 */

public class LoginResponse {

    /**
     * success : true
     * errorMsg :
     * errorCode : 0
     * resultCount : null
     * errorCount : null
     * result : {"userToken":"eyJ0eXAiOiIiLCJhbGciOiJIUzI1NiIsImNsZyI6IiJ9.eyJzdWIiOiIiLCJhdWQiOiIiLCJleHAiOjE1Mjk0ODIwNjcsInVzZXJJZCI6MSwiaWF0IjoxNTI5Mzk1NjY3fQ.1mDBCN4qZUk5Nw7deNnfu-VUGUfBBqzibKYVpOKmx6w","userIcon":"http://hongqian.f3322.net:2290/mates/api/icon/stu.jpg"}
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
         * userToken : eyJ0eXAiOiIiLCJhbGciOiJIUzI1NiIsImNsZyI6IiJ9.eyJzdWIiOiIiLCJhdWQiOiIiLCJleHAiOjE1Mjk0ODIwNjcsInVzZXJJZCI6MSwiaWF0IjoxNTI5Mzk1NjY3fQ.1mDBCN4qZUk5Nw7deNnfu-VUGUfBBqzibKYVpOKmx6w
         * userIcon : http://hongqian.f3322.net:2290/mates/api/icon/stu.jpg
         */

        private String userToken;
        private String userIcon;

        public String getUserToken() {
            return userToken;
        }

        public void setUserToken(String userToken) {
            this.userToken = userToken;
        }

        public String getUserIcon() {
            return userIcon;
        }

        public void setUserIcon(String userIcon) {
            this.userIcon = userIcon;
        }
    }
}
