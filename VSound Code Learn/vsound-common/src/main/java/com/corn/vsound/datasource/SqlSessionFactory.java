package com.corn.vsound.datasource;


import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.IOException;


@Component
@MapperScan("com.corn.vsound.dao.mapper")
public class SqlSessionFactory {

    @Autowired
    DataSource dataSource;

    @Value("${app.jdbc.mapping.path}")
    private String mappingPath;

    @Bean
    public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(pathMatchingResourcePatternResolver.getResources(pathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX+mappingPath));
        return sqlSessionFactoryBean;
    }
}
