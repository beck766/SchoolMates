package com.beck.helloschoolmate.model.http.entity.friend;

import java.util.List;

/**
 * Created by beck on 2018/6/11.
 */

public class NewFriAgreeRequest {

    /**
     * friendId : 0
     * remarkName : string
     * userFriendGroupRIds : [0]
     */

    private int friendId;
    private String remarkName;
    private List<Integer> userFriendGroupRIds;

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

    public List<Integer> getUserFriendGroupRIds() {
        return userFriendGroupRIds;
    }

    public void setUserFriendGroupRIds(List<Integer> userFriendGroupRIds) {
        this.userFriendGroupRIds = userFriendGroupRIds;
    }
}
