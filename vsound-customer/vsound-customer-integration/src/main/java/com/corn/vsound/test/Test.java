package com.corn.vsound.test;

import com.alibaba.dubbo.config.annotation.Reference;
import com.corn.vsound.biz.test.TestService;
import org.springframework.stereotype.Service;

@Service
public class Test {

    @Reference(version = "1.0")
    TestService testService;

    public void say(){
        System.out.println("------------------"+testService);
        testService.say();
    }

}
