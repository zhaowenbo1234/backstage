package com.zhaowb.boot.backstage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author zhaowb [308539393@qq.com]
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.zhaowb.boot.backstage.mapper"})
public class BackstageApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackstageApplication.class, args);
    }
}
