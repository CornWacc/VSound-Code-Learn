package com.corn.vsound;


import com.alibaba.dubbo.config.annotation.Reference;
import com.corn.boot.annotations.Runner;
import com.corn.boot.base.RunMain;
import com.corn.vsound.biz.test.TestService;
import com.corn.vsound.spring.SpringUtil;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Runner(port = "9522", active = "mac")
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class})
@RestController
@EnableDubbo(scanBasePackages = "com.corn.vsound.test")
@PropertySource("classpath:application.properties")
public class Main{

    @Reference(version = "1.0")
    private TestService test;

    @Autowired
    private SpringUtil springUtil;

    public static void main(String[] args) {
        RunMain.springRun(Main.class);

    }

    @GetMapping("/get")
    public void say(){
        test.say();
    }
}
