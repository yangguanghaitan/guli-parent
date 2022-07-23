package com.atguigu.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * @Auther d
 * @Date 2022/7/12 9:34
 * @Describe
 **/
@SpringBootApplication
@ComponentScan("com.atguigu")
public class EduAplication {
    public static void main(String[] args) {
        SpringApplication.run(EduAplication.class);
    }
}
