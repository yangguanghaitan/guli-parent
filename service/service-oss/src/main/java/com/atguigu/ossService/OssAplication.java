package com.atguigu.ossService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Auther d
 * @Date 2022/7/16 15:50
 * @Describe
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan("com.atguigu")
public class OssAplication {
    public static void main(String[] args) {
        SpringApplication.run(OssAplication.class);
    }
}
