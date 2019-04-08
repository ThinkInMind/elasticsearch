package com.d1m.elasticsearch.configure;

import com.d1m.elasticsearch.common.multitenancy.MultitenantDataSource;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;


@Configuration
public class HikariDataSourceConfiguration {

    @Autowired
    private DataSourceProperties properties;


    @Bean
    @ConfigurationProperties(
            prefix = "spring.datasource"
    )
    public DataSource dataSource(){
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDriverClassName(properties.getDriverClassName());
        hikariDataSource.setJdbcUrl(properties.getUrl());
        hikariDataSource.setUsername(properties.getUsername());
        hikariDataSource.setPassword(properties.getPassword());
        MultitenantDataSource multitenantDataSource = new MultitenantDataSource();
        multitenantDataSource.setDefaultTargetDataSource(hikariDataSource);
        multitenantDataSource.setTargetDataSources(new HashMap<>());
        return multitenantDataSource;
    }

}
