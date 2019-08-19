package com.corn.vsound.user.delegate;

import com.corn.boot.base.AbstractBizService;
import com.corn.vsound.dao.entity.UserBase;
import com.corn.vsound.dao.mapper.UserBaseMapper;
import com.corn.vsound.user.info.UserInfo;
import com.corn.vsound.user.list.UserListQueryOrder;
import com.corn.vsound.user.list.UserListQueryResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * @author yyc
 * @apiNote 用户列表查询
 * */
@Service
public class UserListQueryDelegate extends AbstractBizService<UserListQueryOrder, UserListQueryResult> {

    @Autowired
    private UserBaseMapper userBaseMapper;

    @Override
    protected UserListQueryResult initResult() {
        return new UserListQueryResult();
    }

    @Override
    protected void orderCheck(UserListQueryOrder order) {
        order.orderCheck();
    }

    @Override
    protected void appBiz(UserListQueryOrder order, UserListQueryResult result) {
        List<UserBase> userBaseList = userBaseMapper.findUserList();
        if(!ObjectUtils.isEmpty(userBaseList)){
            List<UserInfo> userInfos = new ArrayList<>();
            for(UserBase userBase : userBaseList){
                UserInfo userInfo = new UserInfo();
                BeanUtils.copyProperties(userBase,userInfo);
                userInfos.add(userInfo);
            }
            result.setUserInfoList(userInfos);
        }else{
            result.setUserInfoList(new ArrayList<>());
        }
    }
}
