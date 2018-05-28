package com.heatdeath.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.heatdeath.dao.UserLoginMapper;
import com.heatdeath.pojo.UserLogin;
import com.heatdeath.pojo.UserLoginExample;
import com.heatdeath.service.UserLoginService;

import javax.annotation.Resource;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Resource
    private UserLoginMapper userLoginMapper;

    @Override
    public UserLogin findByName(String name) {
        // 创建一个 userLoginExample 实例
        UserLoginExample userLoginExample = new UserLoginExample();

        // 生成 sql 语句 where username= name
        userLoginExample.or().andUsernameEqualTo(name);

        // 从数据库中获取 name 对应的 UserLogin
        UserLogin userLogin = userLoginMapper.selectByExample(userLoginExample).get(0);
        return userLogin;
    }

    @Override
    public void save(UserLogin userLogin) {
        // 将用户登录信息插入 user_login 表中
        userLoginMapper.insert(userLogin);
    }

    @Override
    public void removeByName(String name) {
        UserLoginExample userLoginExample = new UserLoginExample();
        userLoginExample.or().andUsernameEqualTo(name);
        // 在数据库中删除该 name 对应的 UserLogin 记录
        userLoginMapper.deleteByExample(userLoginExample);
    }

    @Override
    public void updateByName(String name, UserLogin userLogin) {
        UserLoginExample userLoginExample = new UserLoginExample();
        userLoginExample.or().andUsernameEqualTo(name);
        // 在数据库中更新该 name 对应的 UserLogin 记录
        userLoginMapper.updateByExample(userLogin, userLoginExample);
    }
}
