package com.d1m.elasticsearch.configure;

import com.alibaba.druid.pool.DruidDataSource;
import com.d1m.elasticsearch.common.multitenancy.MultitenantDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;


@Configuration
public class DuridDataSourceConfiguration {

    @Autowired
    private DataSourceProperties properties;


    @Bean
    @ConfigurationProperties(
            prefix = "spring.datasource"
    )
    public DataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(properties.getDriverClassName());
        druidDataSource.setUrl(properties.getUrl());
        druidDataSource.setUsername(properties.getUsername());
        druidDataSource.setPassword(properties.getPassword());
        MultitenantDataSource multitenantDataSource = new MultitenantDataSource();
        multitenantDataSource.setDefaultTargetDataSource(druidDataSource);
        multitenantDataSource.setTargetDataSources(new HashMap<>());
        return multitenantDataSource;
    }

}
