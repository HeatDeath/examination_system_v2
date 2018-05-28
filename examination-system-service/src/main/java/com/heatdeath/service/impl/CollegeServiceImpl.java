package com.heatdeath.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.heatdeath.dao.CollegeMapper;
import com.heatdeath.pojo.College;
import com.heatdeath.pojo.CollegeExample;
import com.heatdeath.service.CollegeService;

import javax.annotation.Resource;
import java.util.List;


@Service
public class CollegeServiceImpl implements CollegeService {

    @Resource
    private CollegeMapper collegeMapper;

    // 查找所有学院
    @Override
    public List<College> finAll() throws Exception {
        CollegeExample collegeExample = new CollegeExample();
        collegeExample.or().andCollegeidIsNotNull();
        return collegeMapper.selectByExample(collegeExample);
    }
}
