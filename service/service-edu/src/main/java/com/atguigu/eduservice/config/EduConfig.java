package com.atguigu.eduservice.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther d
 * @Date 2022/7/12 9:36
 * @Describe
 **/
@Configuration
@MapperScan("com.atguigu.eduservice.mapper")
public class EduConfig {

    //逻辑删除插件

    @Bean
    public ISqlInjector getISqlInjector(){
        return new LogicSqlInjector();
    }

}
