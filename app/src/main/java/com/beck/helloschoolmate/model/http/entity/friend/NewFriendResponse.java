package com.beck.helloschoolmate.model.http.entity.friend;

import java.util.List;

/**
 * Created by beck on 2018/6/7.
 */

public class NewFriendResponse {

    /**
     * success : true
     * errorMsg : 
     * errorCode : 0
     * resultCount : null
     * errorCount : null
     * result : [{"requestId":6,"message":"","requesterId":25,"requesterIcon":null,"requesterNickName":null,"requestStatus":null},{"requestId":5,"message":"hi","requesterId":25,"requesterIcon":null,"requesterNickName":null,"requestStatus":null},{"requestId":4,"message":"聊一聊","requesterId":25,"requesterIcon":null,"requesterNickName":null,"requestStatus":null},{"requestId":3,"message":null,"requesterId":1,"requesterIcon":"http://hongqian.f3322.net:2290/mates/api/icon/stu.jpg","requesterNickName":"逼格秩","requestStatus":null},{"requestId":2,"message":"你好，可以聊聊么","requesterId":1,"requesterIcon":"http://hongqian.f3322.net:2290/mates/api/icon/stu.jpg","requesterNickName":"逼格秩","requestStatus":null}]
     * results : null
     */

    private boolean success;
    private String errorMsg;
    private int errorCode;
    private String resultCount;
    private String errorCount;
    private String results;
    private List<ResultBean> result;

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

    public String getResultCount() {
        return resultCount;
    }

    public void setResultCount(String resultCount) {
        this.resultCount = resultCount;
    }

    public String getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(String errorCount) {
        this.errorCount = errorCount;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * requestId : 6
         * message : 
         * requesterId : 25
         * requesterIcon : null
         * requesterNickName : null
         * requestStatus : null
         */

        private int requestId;
        private String message;
        private int requesterId;
        private String requesterIcon;
        private String requesterNickName;
        private int requestStatus;

        public int getRequestId() {
            return requestId;
        }

        public void setRequestId(int requestId) {
            this.requestId = requestId;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getRequesterId() {
            return requesterId;
        }

        public void setRequesterId(int requesterId) {
            this.requesterId = requesterId;
        }

        public String getRequesterIcon() {
            return requesterIcon;
        }

        public void setRequesterIcon(String requesterIcon) {
            this.requesterIcon = requesterIcon;
        }

        public String getRequesterNickName() {
            return requesterNickName;
        }

        public void setRequesterNickName(String requesterNickName) {
            this.requesterNickName = requesterNickName;
        }

        public int getRequestStatus() {
            return requestStatus;
        }

        public void setRequestStatus(int requestStatus) {
            this.requestStatus = requestStatus;
        }
    }
}
