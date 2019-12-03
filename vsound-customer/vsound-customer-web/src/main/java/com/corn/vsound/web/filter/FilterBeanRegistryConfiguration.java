package com.corn.vsound.web.filter;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yyc
 * @apiNote 过滤器初始化注入
 * */
@Configuration
public class FilterBeanRegistryConfiguration {

    @Bean("corsFilter")
    public FilterRegistrationBean corsFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new CorsFilter());
        registrationBean.setOrder(1);
        registrationBean.addUrlPatterns("*");
        return registrationBean;
    }
}
