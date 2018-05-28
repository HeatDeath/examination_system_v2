package com.heatdeath.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.heatdeath.dao.CollegeMapper;
import com.heatdeath.dao.StudentCustomMapper;
import com.heatdeath.dao.StudentMapper;
import com.heatdeath.pojo.Student;
import com.heatdeath.pojo.StudentCustom;
import com.heatdeath.pojo.StudentExample;
import com.heatdeath.service.StudentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Resource
    private CollegeMapper collegeMapper;

    @Resource
    private StudentCustomMapper studentCustomMapper;


    @Override
    public void updateById(Integer id, Student student) throws Exception {
        studentMapper.updateByPrimaryKey(student);
    }

    @Override
    public void removeById(Integer id) throws Exception {
        studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Boolean save(Student student) throws Exception {
        Student result = studentMapper.selectByPrimaryKey(student.getUserid());
        if (result == null) {
            studentMapper.insert(student);
            return true;
        }
        return false;
    }

    @Override
    public long getCountStudent() throws Exception {
        StudentExample studentExample = new StudentExample();
        // where studentId is not null
        studentExample.or().andUseridIsNotNull();
        return studentMapper.countByExample(studentExample);
    }

    @Override
    public StudentCustom findById(Integer id) throws Exception {
        Student student = studentMapper.selectByPrimaryKey(id);
        StudentCustom studentCustom = null;
        if (student != null) {
            studentCustom = new StudentCustom();
            //类拷贝
            BeanUtils.copyProperties(student, studentCustom);
        }
        return studentCustom;
    }

    @Override
    public List<StudentCustom> findByName(Student student, int page, int rows) throws Exception {
        String name;
        if (StringUtils.isEmpty(student.getUsername())) {
            name = "%";
        } else {
            name = "%" + student.getUsername() + "%";
        }

        PageHelper.startPage(page, rows);

        return studentCustomMapper.selectByName(name);
    }
}
