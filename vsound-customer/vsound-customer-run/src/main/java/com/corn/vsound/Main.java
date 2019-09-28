package com.corn.vsound;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.corn.base.spring.DubboScanner;
import com.corn.boot.annotations.Runner;
import com.corn.boot.base.RunMain;
import com.corn.vsound.biz.test.TestService;
import com.corn.vsound.spring.SpringUtil;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Runner(port = "9522", active = "window")
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class})
@RestController
public class Main implements CommandLineRunner{

    @Reference(version = "1.0")
    private TestService test;

    @Autowired
    private SpringUtil springUtil;

    public static void main(String[] args) {
        RunMain.springRun(Main.class);

    }

    @NacosInjected
    private NamingService namingService;

    @GetMapping(value = "/get")
    public List<Instance> get(String serviceName) throws NacosException {
        test.say();
        return namingService.getAllInstances(serviceName);
    }

    public void run(String... args) throws Exception {
        DubboScanner scanner = springUtil.getBean(DubboScanner.class);
        System.out.println(scanner.getClass().getAnnotation(EnableDubbo.class));
    }
}
