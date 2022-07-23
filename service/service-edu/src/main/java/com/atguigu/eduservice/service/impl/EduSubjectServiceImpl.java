package com.atguigu.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import com.atguigu.commonutils.tree.TreeUtils;
import com.atguigu.eduservice.entity.EduSubject;
import com.atguigu.eduservice.entity.excel.SubjsctData;
import com.atguigu.eduservice.listener.SubjectExcelListener;
import com.atguigu.eduservice.mapper.EduSubjectMapper;
import com.atguigu.eduservice.service.EduSubjectService;
import com.atguigu.servicebase.exceptionHandler.GuliException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-07-17
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {


    @Override
    public void readSubjectExcelData(MultipartFile excelDataFile) throws IOException {
        if (excelDataFile==null){
            throw new GuliException(5,"课程分类excel表格数据为空");
        }
        InputStream excelDataFileInputStream = excelDataFile.getInputStream();
        EasyExcel.read(excelDataFileInputStream, SubjsctData.class,new SubjectExcelListener(this)).sheet().doRead();
    }

    @Override
    public List<EduSubject> searchSubject() {
        QueryWrapper<EduSubject> queryWrapper=new QueryWrapper<>();
        queryWrapper.orderByAsc("sort");
        //查询所有课程
        List<EduSubject> eduSubjects = baseMapper.selectList(queryWrapper);
        //构造成树形结构
        List<EduSubject> eduSubjectsTree = TreeUtils.generateTrees(eduSubjects);
        return eduSubjectsTree;
    }
}
