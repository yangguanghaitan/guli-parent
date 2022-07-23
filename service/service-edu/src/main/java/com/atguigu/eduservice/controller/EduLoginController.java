package com.atguigu.eduservice.controller;

import com.atguigu.commonutils.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther d
 * @Date 2022/7/13 23:35
 * @Describe
 **/
@Api(description = "登录模块")
@Controller
@RequestMapping("/eduService/uer")
@CrossOrigin()
public class EduLoginController {

    @ApiOperation("用户登录接口")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult login(){
        Map map=new HashMap();
        map.put("token","admin");
        return AjaxResult.success(map);
    }

    @ApiOperation("获取用户信息接口")
    @RequestMapping(value = "/getUserInfo",method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult getUserInfo(){
        Map map=new HashMap();
        map.put("roles","[admin]");
        map.put("name","admin");
        map.put("avatar","https://guli-file-190513.oss-cn-beijing.aliyuncs.com/avatar/default.jpg");
        return AjaxResult.success(map);
    }
}
