package com.beck.helloschoolmate.model.http.entity.addfriend;

/**
 * Created by beck on 2018/5/31.
 */

public class AddFriendSendRequest {

    /**
     * friendGroupId : 0
     * message : 你好，可以聊聊么
     * remarkName : 林
     * toUserId : 1
     */

    private int friendGroupId;
    private String message;
    private String remarkName;
    private int toUserId;

    public int getFriendGroupId() {
        return friendGroupId;
    }

    public void setFriendGroupId(int friendGroupId) {
        this.friendGroupId = friendGroupId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRemarkName() {
        return remarkName;
    }

    public void setRemarkName(String remarkName) {
        this.remarkName = remarkName;
    }

    public int getToUserId() {
        return toUserId;
    }

    public void setToUserId(int toUserId) {
        this.toUserId = toUserId;
    }
}
