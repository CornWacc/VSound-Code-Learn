package com.corn.base.spring;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableDubbo(scanBasePackages = "${dubbo.scan.package}")
@PropertySource("classpath:application.properties")
public class DubboScanner {
}
