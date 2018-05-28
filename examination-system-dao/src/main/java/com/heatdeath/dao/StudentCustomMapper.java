package com.heatdeath.dao;

import com.heatdeath.pojo.StudentCustom;

import java.util.List;

public interface StudentCustomMapper {
    //分页查询学生信息
    List<StudentCustom> selectByName(String name);

}
