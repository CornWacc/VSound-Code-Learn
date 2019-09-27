package com.corn.vsound.biz.test;


import com.alibaba.dubbo.config.annotation.Service;

@Service
public class TestServiceImpl implements TestService {

    public String say() {
        return "hello";
    }

}
