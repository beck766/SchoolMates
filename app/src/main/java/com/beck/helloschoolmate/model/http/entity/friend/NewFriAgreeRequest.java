package com.beck.helloschoolmate.model.http.entity.friend;

/**
 * Created by beck on 2018/6/11.
 */

public class NewFriAgreeRequest {

    /**
     * friendGroupId : 0
     * friendId : 25
     * remarkName : string
     */

    private int friendGroupId;
    private int friendId;
    private String remarkName;

    public int getFriendGroupId() {
        return friendGroupId;
    }

    public void setFriendGroupId(int friendGroupId) {
        this.friendGroupId = friendGroupId;
    }

    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    public String getRemarkName() {
        return remarkName;
    }

    public void setRemarkName(String remarkName) {
        this.remarkName = remarkName;
    }
}
