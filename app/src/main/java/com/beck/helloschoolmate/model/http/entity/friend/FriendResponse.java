package com.beck.helloschoolmate.model.http.entity.friend;

import java.util.List;

/**
 * Created by beck on 2018/6/11.
 */

public class FriendResponse {

    /**
     * success : true
     * errorMsg :
     * errorCode : 0
     * resultCount : null
     * errorCount : null
     * result : [{"friendId":1,"friendName":"","friendIcon":"192.168.31.98:2290/mates/api/icon/stu.jpg"}]
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
         * friendId : 1
         * friendName :
         * friendIcon : 192.168.31.98:2290/mates/api/icon/stu.jpg
         */

        private int friendId;
        private String friendName;
        private String friendIcon;

        public int getFriendId() {
            return friendId;
        }

        public void setFriendId(int friendId) {
            this.friendId = friendId;
        }

        public String getFriendName() {
            return friendName;
        }

        public void setFriendName(String friendName) {
            this.friendName = friendName;
        }

        public String getFriendIcon() {
            return friendIcon;
        }

        public void setFriendIcon(String friendIcon) {
            this.friendIcon = friendIcon;
        }
    }
}
