package com.heatdeath.dao;

import com.heatdeath.pojo.TeacherCustom;
import com.heatdeath.pojo.TeacherExample;

import java.util.List;

public interface TeacherCustomMapper {

    //分页查询教师信息
    List<TeacherCustom> selectByExample(TeacherExample example);
}
