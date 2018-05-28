package com.heatdeath.dao;

import com.heatdeath.pojo.SelectedCourse;
import com.heatdeath.pojo.SelectedCourseExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SelectedCourseMapper {
    long countByExample(SelectedCourseExample example);

    int deleteByExample(SelectedCourseExample example);

    int insert(SelectedCourse record);

    int insertSelective(SelectedCourse record);

    List<SelectedCourse> selectByExample(SelectedCourseExample example);

    int updateByExampleSelective(@Param("record") SelectedCourse record, @Param("example") SelectedCourseExample example);

    int updateByExample(@Param("record") SelectedCourse record, @Param("example") SelectedCourseExample example);
}