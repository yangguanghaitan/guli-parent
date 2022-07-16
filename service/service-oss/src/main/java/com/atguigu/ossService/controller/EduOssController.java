package com.atguigu.ossService.controller;

import com.atguigu.commonutils.AjaxResult;
import com.atguigu.ossService.ConstantEntity.AliyunOssProperties;
import com.atguigu.ossService.service.OssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther d
 * @Date 2022/7/16 16:28
 * @Describe
 **/
@Controller
@RequestMapping("/ossService/oss")
@Api(description = "阿里云oss存储模块")
@CrossOrigin()
public class EduOssController {
    @Autowired
    private OssService ossService;

    @ApiOperation("讲师头像保存")
    @RequestMapping(value = "/updateAvatar",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult updateAvatar(MultipartFile file1) {

        String avatarUrl = ossService.updateAvatar(file1);
        Map map=new HashMap();
        map.put("avatarUrl",avatarUrl);
        return AjaxResult.success("成功",map);
    }




    @RequestMapping(value = "/aa",method = RequestMethod.GET)
    @ResponseBody
    public String aa(){
        return AliyunOssProperties.BUCKET_NAME;
    }
}
