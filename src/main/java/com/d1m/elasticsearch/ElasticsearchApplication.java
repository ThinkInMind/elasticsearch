package com.d1m.elasticsearch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringCloudApplication
@PropertySource({"classpath:bootstrap.yml","classpath:application.yml"})
@MapperScan("com.d1m.elasticsearch.repository")
@ComponentScan("com.d1m.elasticsearch")
public class ElasticsearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchApplication.class);
    }
}
