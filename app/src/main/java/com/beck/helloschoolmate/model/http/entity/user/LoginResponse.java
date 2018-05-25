package com.beck.helloschoolmate.model.http.entity.user;

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
     * result : {"userToken":"eyJ0eXAiOiIiLCJhbGciOiJIUzI1NiIsImNsZyI6IiJ9.eyJzdWIiOiIiLCJhdWQiOiIiLCJleHAiOjE1MjY5NzUxMDcsInVzZXJJZCI6MSwiaWF0IjoxNTI2OTcxNTA3fQ.ETJ-FVGvxd_t0XG-Zsney5Fl9rA6EFxVyQUlaxvMYiY"}
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
         * userToken : eyJ0eXAiOiIiLCJhbGciOiJIUzI1NiIsImNsZyI6IiJ9.eyJzdWIiOiIiLCJhdWQiOiIiLCJleHAiOjE1MjY5NzUxMDcsInVzZXJJZCI6MSwiaWF0IjoxNTI2OTcxNTA3fQ.ETJ-FVGvxd_t0XG-Zsney5Fl9rA6EFxVyQUlaxvMYiY
         */

        private String userToken;

        public String getUserToken() {
            return userToken;
        }

        public void setUserToken(String userToken) {
            this.userToken = userToken;
        }
    }
}
