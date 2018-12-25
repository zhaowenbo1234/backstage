package com.zhaowb.boot.backstage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author zhaowb [308539393@qq.com]
 */
@SpringBootApplication
@MapperScan(basePackages = "com.zhaowb.boot.backstage.mapper")
public class BackstageApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackstageApplication.class, args);
    }
}
