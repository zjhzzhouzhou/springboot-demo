package com.gupao.springbootdemo.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gupao.springbootdemo.user.dao.UserMapper;
import com.gupao.springbootdemo.user.domain.User;
import com.gupao.springbootdemo.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类UserServiceImpl.java的实现描述：用户测试表 serviceimpl
 *
 * @author yupeng 2020-06-19 15:00:37
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public User findByUserId(Long userId) {
        return userMapper.getUserById(userId);

    }

    @Override
    public PageInfo<User> findUserList(User user) {
        PageHelper.startPage(1, 10);
        List<User> users = userMapper.listByPara(user);
        return new PageInfo<>(users);
    }

    @Override
    public Long insertUser(User user) {
        userMapper.insert(user);
        return user.getId();
    }

    @Override
    public User updateByUserId(User user, Long userId) {
        user.setId(userId);
        userMapper.updateById(user);
        return findByUserId(userId);
    }
}
