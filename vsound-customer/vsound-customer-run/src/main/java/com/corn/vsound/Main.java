package com.corn.vsound;


import com.corn.boot.annotations.Runner;
import com.corn.boot.aop.LogAop;
import com.corn.boot.base.RunMain;
import com.corn.boot.configuration.DataSourcePropertiesAutoConfiguration;
import com.corn.vsound.spring.SpringUtil;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RestController;

@Runner(port = "9522", active = "mac")
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,com.corn.boot.configuration.DataSourceAutoConfiguration.class, DataSourcePropertiesAutoConfiguration.class})
@ImportResource("classpath:dubbo-admin.xml")
@Import(LogAop.class)
public class Main{

    public static void main(String[] args) {
        RunMain.springRun(Main.class);

    }

}
