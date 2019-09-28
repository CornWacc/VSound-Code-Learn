package com.corn.base.spring;

import org.apache.dubbo.config.spring.context.annotation.DubboClassPathBeanDefinitionScanner;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScanRegistrar;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableDubbo()
@PropertySource("classpath:application.properties")
public class DubboScanner {

}
