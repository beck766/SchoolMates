package com.beck.helloschoolmate.model.http.entity.addfriend;

import java.util.List;

/**
 * Created by beck on 2018/5/31.
 */

public class AddFriendSendRequest {


    /**
     * message : string
     * remarkName : string
     * toUserId : 0
     * userFriendGroupRIds : [0]
     */

    private String message;
    private String remarkName;
    private int toUserId;
    private List<Integer> userFriendGroupRIds;

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

    public List<Integer> getUserFriendGroupRIds() {
        return userFriendGroupRIds;
    }

    public void setUserFriendGroupRIds(List<Integer> userFriendGroupRIds) {
        this.userFriendGroupRIds = userFriendGroupRIds;
    }
}
