package com.d1m.elasticsearch.common.multitenancy;

import com.d1m.elasticsearch.configure.MybatisSelectConfigure;
import com.d1m.elasticsearch.repository.MultiTenantRepository;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@AutoConfigureAfter(MybatisSelectConfigure.class)
public class MultitenantConfiguration {

    @Autowired
    private MultiTenantRepository multiTenantRepository;
    @Autowired
    private DataSourceProperties properties;
    @Autowired
    DataSource dataSource;

    @Bean
    public boolean TargetDataSources(){
        List<JDBCConfig> jdbcConfigList = getJDBCList();
        Map<Object,Object> resolvedDataSources = new HashMap<>();
        jdbcConfigList.forEach(jdbcConfig -> {
            HikariDataSource hikariDataSource = getDataSource(jdbcConfig);
            resolvedDataSources.put(jdbcConfig.getWechatId(), hikariDataSource);
        });

        if(dataSource instanceof MultitenantDataSource){
            MultitenantDataSource multitenantDataSource = (MultitenantDataSource) dataSource;
            multitenantDataSource.setTargetDataSources(resolvedDataSources);
            multitenantDataSource.afterPropertiesSet();
        }
        return true;
    }

    public List<JDBCConfig> getJDBCList(){
        TenantContext.setCurrentTenant(0);
        List<Map<String,Object>> multiTenantlist = multiTenantRepository.listAll();
        List<JDBCConfig> jdbcConfigList = new ArrayList<>();
        multiTenantlist.forEach(stringMap -> {
            JDBCConfig jdbcConfig = new JDBCConfig();
            jdbcConfig.setWechatId((Integer) stringMap.get("wechatId"));
            jdbcConfig.setUrl(stringMap.get("jdbcUrl").toString());
            jdbcConfig.setUserName(stringMap.get("username").toString());
            jdbcConfig.setPassword(stringMap.get("password").toString());
            jdbcConfigList.add(jdbcConfig);
        });
        return jdbcConfigList;
    }

    public HikariDataSource getDataSource(JDBCConfig jdbcConfig){
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setMaximumPoolSize(16);
        hikariDataSource.setDriverClassName(properties.getDriverClassName());
        hikariDataSource.setJdbcUrl(jdbcConfig.getUrl());
        hikariDataSource.setUsername(jdbcConfig.getUserName());
        hikariDataSource.setPassword(jdbcConfig.getPassword());
        return hikariDataSource;
    }
}
