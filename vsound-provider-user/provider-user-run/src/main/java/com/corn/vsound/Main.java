package com.corn.vsound;


import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.corn.boot.annotations.Runner;
import com.corn.boot.base.RunMain;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Runner(port = "9099",active = "mac")
@NacosPropertySource(dataId = "example",autoRefreshed = true)
@RestController
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
