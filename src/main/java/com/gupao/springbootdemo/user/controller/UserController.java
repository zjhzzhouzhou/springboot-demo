package com.gupao.springbootdemo.user.controller;

import com.github.pagehelper.PageInfo;
import com.gupao.springbootdemo.user.domain.User;
import com.gupao.springbootdemo.user.dto.UserUpdateRequest;
import com.gupao.springbootdemo.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 类UserController.java的实现描述：用户测试表 Controller
 *
 * @author yupeng 2020-06-19 15:00:37
 */
@RestController
@Api(tags = "用户测试接口")
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation("插入用户")
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public Long insertUser(@RequestBody User user) {
        return userService.insertUser(user);
    }

    @ApiOperation("更新用户")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public User updateUser(@RequestBody UserUpdateRequest userUpdateRequest) {
        return userService.updateByUserId(userUpdateRequest.getUser(), userUpdateRequest.getUserId());
    }

    @ApiOperation("分页查询用户")
    @RequestMapping(value = "/page",method = RequestMethod.POST)
    public PageInfo<User> page(@RequestBody User user) {
        return userService.findUserList(user);
    }

    @ApiOperation("查询ById")
    @RequestMapping(value = "/findById",method = RequestMethod.GET)
    public User findById(Long userId) {
        return userService.findByUserId(userId);
    }
}
