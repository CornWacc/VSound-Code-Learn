package com.corn.vsound.web.account;

import com.corn.boot.error.BizError;
import com.corn.vworld.facade.user.login.UserLoginResult;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class AccountCache {

    public final ThreadLocal<UserLoginResult> userCache = new InheritableThreadLocal<>();

    public UserLoginResult getUserCache(){

        System.out.println(userCache.get());
        UserLoginResult cache = userCache.get();
        if(ObjectUtils.isEmpty(cache)){
            throw new BizError("该线程暂无缓存");
        }
        return cache;
    }

    public void setUserCache(UserLoginResult userLoginResult){
        userCache.set(userLoginResult);
    }

    public void clearLocalCache(){
        userCache.remove();
    }

}
