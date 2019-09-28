package com.corn.vsound.biz.test;


import com.alibaba.dubbo.config.annotation.Service;

@Service(version = "1.0")
public class TestServiceImpl implements TestService {

    public String say() {
        System.out.println("hello");
        return "hello";
    }

}
