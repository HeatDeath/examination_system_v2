package com.heatdeath.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.heatdeath.dao.RoleMapper;
import com.heatdeath.pojo.Role;
import com.heatdeath.service.RoleService;

import javax.annotation.Resource;


@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public Role findById(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }
}
