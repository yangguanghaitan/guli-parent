package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.AjaxResult;
import com.atguigu.eduservice.entity.EduSubject;
import com.atguigu.eduservice.service.EduSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-07-17
 */
@Api(description = "课程分类模块")
@Controller
@RequestMapping("/eduservice/subject")
@CrossOrigin()
public class EduSubjectController {

    @Autowired
    private EduSubjectService subjectService;

    @ApiOperation("读取课程分类的excel数据")
    @RequestMapping(value = "readSubjectExcelData", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult readSubjectExcelData(MultipartFile excelDataFile) throws IOException {
        subjectService.readSubjectExcelData(excelDataFile);
        return AjaxResult.success();
    }
    @ApiOperation("课程分类查询")
    @RequestMapping(value = "listSubject", method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult searchSubject() throws IOException {
        List<EduSubject> oneSubjectsTree=subjectService.searchSubject();
        return AjaxResult.success(oneSubjectsTree);
    }
}

