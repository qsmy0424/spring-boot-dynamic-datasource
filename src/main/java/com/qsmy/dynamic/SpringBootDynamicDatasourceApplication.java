package com.qsmy.dynamic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author qsmy
 */
@SpringBootApplication
@MapperScan(basePackages = "com.qsmy.dynamic.mapper")
public class SpringBootDynamicDatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDynamicDatasourceApplication.class, args);
    }

}
