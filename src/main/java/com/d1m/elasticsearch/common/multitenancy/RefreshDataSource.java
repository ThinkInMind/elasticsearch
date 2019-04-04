package com.d1m.elasticsearch.common.multitenancy;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RefreshDataSource {

    @Autowired
    DataSource dataSource;

    @Autowired
    private DataSourceProperties properties;

    @Autowired
    private MultitenantConfiguration multitenantConfiguration;

    public DataSource refreshDataSource(List<JDBCConfig> jdbcConfigList) {

        Map<Object,Object> resolvedDataSources = new HashMap<>();
        jdbcConfigList.forEach(jdbcConfig -> {
            DruidDataSource druidDataSource = multitenantConfiguration.getDataSource(jdbcConfig);
            resolvedDataSources.put(jdbcConfig.getWechatId(), druidDataSource);
        });

        MultitenantDataSource multitenantDataSource = (MultitenantDataSource) dataSource;
        multitenantDataSource.setTargetDataSources(resolvedDataSources);
        multitenantDataSource.afterPropertiesSet();
        return multitenantDataSource;
    }
}
