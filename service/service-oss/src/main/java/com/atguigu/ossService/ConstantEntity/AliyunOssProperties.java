package com.atguigu.ossService.ConstantEntity;

import lombok.Data;
import lombok.Setter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther d
 * @Date 2022/7/16 16:02
 * @Describe
 **/
@Configuration
@ConfigurationProperties(prefix = "aliyun.oss")
@Setter
public class AliyunOssProperties implements InitializingBean {

//    @Value("${endpoint}")
    private String endpoint;
//    @Value("${accessKeyId}")
    private String accessKeyId;
//    @Value("${accessKeySecret}")
    private String accessKeySecret;
//    @Value("${bucketName}")
    private String bucketName;

//    @Value("${avatarPath}")
    private String avatarPath;


    public static String END_POINT;
    public static String ACCESS_KEY_ID;
    public static String ACCESS_KEY_SECRET;
    public static String BUCKET_NAME;
    public static String AVATAR_PATH;

    @Override
    public void afterPropertiesSet() throws Exception {
        END_POINT=endpoint;
        ACCESS_KEY_ID=accessKeyId;
        ACCESS_KEY_SECRET=accessKeySecret;
        BUCKET_NAME=bucketName;
        AVATAR_PATH=avatarPath;
    }
}
