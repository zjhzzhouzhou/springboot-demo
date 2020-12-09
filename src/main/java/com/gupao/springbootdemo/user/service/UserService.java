package com.gupao.springbootdemo.user.service;

import com.github.pagehelper.PageInfo;
import com.gupao.springbootdemo.user.domain.User;

/**
 * 类UserService.java的实现描述：用户测试表 service
 *
 * @author yupeng 2020-06-19 15:00:37
 */
public interface UserService {

    User findByUserId(Long userId);

    PageInfo<User> findUserList(User user);

    Long insertUser(User user);

    User updateByUserId(User user, Long userId);
}
