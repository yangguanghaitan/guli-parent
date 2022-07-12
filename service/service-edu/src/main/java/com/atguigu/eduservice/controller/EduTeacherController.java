package com.atguigu.eduservice.controller;


import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-07-12
 */
@Api(description = "讲师模块")
@Controller
@RequestMapping("/eduservice/teacher")
public class EduTeacherController {

    @Autowired
    EduTeacherService eduTeacherService;

    @ApiOperation(value = "查询所有讲师")
    @RequestMapping(value = "/listAll",method = RequestMethod.GET)
    @ResponseBody
    public List<EduTeacher> listAll(){
        List<EduTeacher> listTeachers = eduTeacherService.list(null);
        return listTeachers;
    }

    @ApiOperation(value = "逻辑删除讲师")
    @RequestMapping(value = "/deleteById/{ida}",method = RequestMethod.GET)
    @ResponseBody
    public Boolean deleteById(@ApiParam(name = "ida",value = "讲师id1",required = true) @PathVariable("ida")String id){
        System.out.println(id);
        boolean flag = eduTeacherService.removeById(id);
        return flag;
    }
}

