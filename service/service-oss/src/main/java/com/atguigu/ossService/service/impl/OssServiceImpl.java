package com.atguigu.ossService.service.impl;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.PutObjectRequest;
import com.atguigu.ossService.ConstantEntity.AliyunOssProperties;
import com.atguigu.ossService.service.OssService;
import com.atguigu.servicebase.exceptionHandler.GuliException;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Auther d
 * @Date 2022/7/16 16:31
 * @Describe
 **/
@Service
public class OssServiceImpl implements OssService {
    @Override
    public String updateAvatar(MultipartFile file) {

        String endpoint = AliyunOssProperties.END_POINT;
        String accessKeyId = AliyunOssProperties.ACCESS_KEY_ID;
        String accessKeySecret = AliyunOssProperties.ACCESS_KEY_SECRET;
        String bucketName = AliyunOssProperties.BUCKET_NAME;

        //构建存储路径加名字
        String filePath = new DateTime().toString("yyyy/MM/dd");
        String originalFilename = file.getOriginalFilename();
        String fileName = UUID.randomUUID().toString().replaceAll("-","");
        String objectName=AliyunOssProperties.AVATAR_PATH+filePath+"/"+fileName+originalFilename;

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try {
            // 创建PutObjectRequest对象。
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, file.getInputStream());

            // 上传文件。
            ossClient.putObject(putObjectRequest);
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
//            throw new GuliException(e.getMessage());
            throw new GuliException("上传头像路径有问题");
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        String returnUrl="https://"+AliyunOssProperties.BUCKET_NAME+"."+AliyunOssProperties.END_POINT+"/"+objectName;
        return returnUrl;
    }
}
