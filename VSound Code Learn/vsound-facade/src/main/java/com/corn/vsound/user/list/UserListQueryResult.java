package com.corn.vsound.user.list;

import com.corn.boot.base.BaseRes;
import com.corn.vsound.user.info.UserInfo;

import java.util.List;


/**
 * @author yyc
 * @apiNote 用户列表查询出参
 * */
public class UserListQueryResult extends BaseRes {
    private static final long serialVersionUID = -1543477233141586199L;

    private List<UserInfo> userInfoList;

    public List<UserInfo> getUserInfoList() {
        return userInfoList;
    }

    public void setUserInfoList(List<UserInfo> userInfoList) {
        this.userInfoList = userInfoList;
    }
}
