package com.d1m.elasticsearch.common.multitenancy;

import lombok.Data;

@Data
public class JDBCConfig {
    private String driverName;
    private String url;
    private String userName;
    private String password;
    private Integer wechatId;

}
