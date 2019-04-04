package com.d1m.elasticsearch.configure;

//import org.apache.ibatis.session.Configuration;

import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mapping.MappingException;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

/**
 * MybatisSelectConfiguration
 *
 * @author f0rb on 2017-08-10.
 */
@Configuration
@AutoConfigureAfter({MybatisAutoConfiguration.class})
public class MybatisSelectConfigure implements InitializingBean, ApplicationContextAware {

    private String[]           locations = {"classpath*:com/d1m/elasticsearch/repository/*.xml"};
    private SqlSessionFactory  sqlSessionFactory;
    private ApplicationContext applicationContext;


    @Override
    public void afterPropertiesSet() throws Exception {
        if (StringUtils.isEmpty(locations)) {
            return;
        }

        org.apache.ibatis.session.Configuration configuration = sqlSessionFactory.getConfiguration();
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setCallSettersOnNulls(true);
        for (String s : locations) {
            if (StringUtils.isEmpty(s)) {
                continue;
            }

            org.springframework.core.io.Resource[] resources = applicationContext.getResources(s);
            if (null == resources || resources.length == 0) {
                continue;
            }
            for (org.springframework.core.io.Resource r : resources) {
                InputStream inputStream = r.getInputStream();
                String namespace = r.getFilename();
                String rr = "after_" + namespace;

                XMLMapperBuilder xmlMapperBuilder = new XMLMapperBuilder(inputStream, configuration, rr, configuration.getSqlFragments());
                try {
                    xmlMapperBuilder.parse();
                } catch (Exception e) {
                    throw new MappingException("parse after mapping error for " + namespace, e);
                } finally {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        // ignore
                    }
                }
            }
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) throws IOException {
        this.sqlSessionFactory = sqlSessionFactory;
    }
}
