package com.corn.vsound;


import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.corn.boot.annotations.Runner;
import com.corn.boot.base.RunMain;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Runner(port = "9099",active = "window")
@NacosPropertySource(dataId = "example",autoRefreshed = true)
@RestController
@Configuration
@EnableDubbo(scanBasePackages = "com.corn.vsound.biz")
@PropertySource("classpath:application-window.properties")
public class Main {

    public static void main(String[] args) {

        RunMain.springRun(Main.class);
    }

    @NacosValue(value = "${useLocalCache:false}",autoRefreshed = true)
    private boolean useLocalCache;

    @GetMapping(value = "/get")
    public boolean get(){
        return useLocalCache;
    }
}
