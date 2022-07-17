package com.atguigu.eduservice.service;

import com.atguigu.eduservice.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author testjava
 * @since 2022-07-17
 */
public interface EduSubjectService extends IService<EduSubject> {

    void readSubjectExcelData(MultipartFile excelDataFile) throws IOException;
}
