package com.atguigu.eduservice.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @Auther d
 * @Date 2022/7/17 18:53
 * @Describe
 **/
@Data
@ToString
public class SubjsctData {
    @ExcelProperty(value = "一级标题",index = 0)
    private String oneSubject;
    @ExcelProperty(value = "二级标题",index = 1)
    private String twoSubject;
}
