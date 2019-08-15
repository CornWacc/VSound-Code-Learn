package com.corn.vsound.datasource;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author yyc
 * @apiNote 数据原
 * */
@Configuration
public class DataSource {

    @Value("${app.jdbc.driver}")
    private String jdbcDriver;

    @Value("${app.jdbc.url}")
    private String jdbcUrl;

    @Value("${app.jdbc.userName}")
    private String jdbcUserName;

    @Value("${app.jdbc.password}")
    private String jdbcPassword;

    @Bean()
    public DruidDataSource druidDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();

        druidDataSource.setDriverClassName(jdbcDriver);
        druidDataSource.setUsername(jdbcUserName);
        druidDataSource.setPassword(jdbcPassword);
        druidDataSource.setUrl(jdbcUrl);
        return druidDataSource;
    }
}
