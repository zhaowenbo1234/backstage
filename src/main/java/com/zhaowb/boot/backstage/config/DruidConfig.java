package com.zhaowb.boot.backstage.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created with IDEA
 *
 * @author zhaowb
 * @date 2018/12/5 15:03
 */
@Configuration
public class DruidConfig {

    //  不加入initMethod 在访问druid数据源页面上显示(*) property for user to setup
    @Bean(destroyMethod = "close",initMethod = "init")
    @ConfigurationProperties("spring.datasource.druid")
    public DataSource dataSource(){
        return DruidDataSourceBuilder.create().build();
    }
}
