package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.AjaxResult;
import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.entity.vo.TeacherQuery;
import com.atguigu.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult listAll() {
        List<EduTeacher> listTeachers = eduTeacherService.list(null);
        return AjaxResult.success(listTeachers);
    }

    @ApiOperation(value = "逻辑删除讲师")
    @RequestMapping(value = "/deleteById/{ida}", method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult deleteById(@ApiParam(name = "ida", value = "讲师id1", required = true) @PathVariable("ida") String id) {
        System.out.println(id);
        boolean flag = eduTeacherService.removeById(id);
        return AjaxResult.success(flag);
    }


    @ApiOperation(value = "讲师分页查询")
    @RequestMapping(value = "/getPageTeacher/{current}/{limit}", method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult getPageTeacher(
            @ApiParam(name = "current", value = "当前页码", required = false) @PathVariable("current") Long current,
            @ApiParam(name = "limit", value = "每页数量", required = false) @PathVariable("limit") Long limit) {

        Page<EduTeacher> teacherPage = new Page<>(current, limit);
        eduTeacherService.page(teacherPage, null);
        List<EduTeacher> records = teacherPage.getRecords();
        long total = teacherPage.getTotal();

        Map map = new HashMap();
        map.put("total", total);
        map.put("records", records);

        return AjaxResult.success(map);
    }

    @ApiOperation(value = "讲师分页条件模糊查询")
    @RequestMapping(value = "/getPageTeacherCondition/{current}/{limit}", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult getPageTeacherCondition(
            @ApiParam(name = "current", value = "当前页码", required = false) @PathVariable("current") Long current,
            @ApiParam(name = "limit", value = "每页数量", required = false) @PathVariable("limit") Long limit,
            @ApiParam(name = "teacherQuery", value = "封装查询条件", required = false) @RequestBody(required = false) TeacherQuery teacherQuery) {

        Page<EduTeacher> teacherPage = new Page<>(current, limit);
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper();

        if (teacherQuery == null) {
            eduTeacherService.page(teacherPage, wrapper);

            List<EduTeacher> records = teacherPage.getRecords();
            long total = teacherPage.getTotal();

            Map map = new HashMap();
            map.put("total", total);
            map.put("records", records);

            return AjaxResult.success(map);
        }
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        if (!StringUtils.isEmpty(name)) {
            wrapper.like("name", name);//模糊
        }
        if (!StringUtils.isEmpty(level)) {
            wrapper.eq("level", level);//等于
        }
        if (!StringUtils.isEmpty(begin)) {
            wrapper.ge("gmt_create", begin);//大于
        }
        if (!StringUtils.isEmpty(end)) {
            wrapper.le("gmt_create", end);//小于
        }

        eduTeacherService.page(teacherPage, wrapper);

        List<EduTeacher> records = teacherPage.getRecords();
        long total = teacherPage.getTotal();

        Map map = new HashMap();
        map.put("total", total);
        map.put("records", records);

        return AjaxResult.success(map);
    }


    @ApiOperation(value = "讲师新增")
    @RequestMapping(value = "/addTeacher", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult addTeacher(
            @ApiParam(name = "teacher", value = "新增的讲师", required = false) @RequestBody(required = false) EduTeacher eduTeacher) {
        boolean save = eduTeacherService.save(eduTeacher);
        if (save) {
            return AjaxResult.success("讲师新增成功");
        }
        return AjaxResult.error("讲师新增失败");

    }

    @ApiOperation(value = "根据Id查询讲师")
    @RequestMapping(value = "/getTeacherById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult getTeacherById(
            @ApiParam(name = "idd", value = "讲师Id", required = true) @PathVariable("id") String id) {

        EduTeacher teacher = eduTeacherService.getById(id);
        return AjaxResult.success(teacher);
    }

    @ApiOperation(value = "根据Id修改讲师")
    @RequestMapping(value = "/updateTeacherbyId", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult updateTeacherbyId(
            @ApiParam(name = "teacher", value = "要修改的讲师", required = true) @RequestBody(required = true) EduTeacher eduTeacher) {

        boolean flag = eduTeacherService.updateById(eduTeacher);
        if (flag) {
            return AjaxResult.success("根据Id修改讲师成功");
        }
        return AjaxResult.success("根据Id修改讲师失败");

    }
}



