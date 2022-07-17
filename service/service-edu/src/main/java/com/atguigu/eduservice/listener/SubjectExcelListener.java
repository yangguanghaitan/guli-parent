package com.atguigu.eduservice.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.atguigu.eduservice.entity.EduSubject;
import com.atguigu.eduservice.entity.excel.SubjsctData;
import com.atguigu.eduservice.service.EduSubjectService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.util.Map;

/**
 * @Auther d
 * @Date 2022/7/17 19:06
 * @Describe 读取课程分类的EXCEL表格数据
 **/

public class SubjectExcelListener extends AnalysisEventListener<SubjsctData> {
    private EduSubjectService subjectService;

    public SubjectExcelListener(EduSubjectService subjectService) {
        this.subjectService = subjectService;
    }

    public SubjectExcelListener() {
    }

    @Override
    public void invoke(SubjsctData subjsctData, AnalysisContext analysisContext) {
        EduSubject one = existOneSubject(subjsctData.getOneSubject());
        if (one==null){
            one=new EduSubject();
            one.setParentId("0");
            one.setTitle(subjsctData.getOneSubject());
            subjectService.save(one);
        }

        String pid = one.getId();
        EduSubject two = existTwoSubject(pid, subjsctData.getTwoSubject());
        if (two==null){
            two=new EduSubject();
            two.setParentId(pid);
            two.setTitle(subjsctData.getTwoSubject());
            subjectService.save(two);
        }
    }

    //判断一级目录是否重复
    public EduSubject existOneSubject(String oneSubject) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("title", oneSubject);
        wrapper.eq("parent_id", "0");
        EduSubject one = subjectService.getOne(wrapper);
        return one;
    }

    //判断二级目录是否重复
    public EduSubject existTwoSubject(String pid, String twoSubject) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("title", twoSubject);
        wrapper.eq("parent_id", pid);
        EduSubject two = subjectService.getOne(wrapper);
        return two;

    }


    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("表格头部数据==" + headMap);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
