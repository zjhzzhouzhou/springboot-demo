package com.gupao.springbootdemo.user.convert;

import com.gupao.springbootdemo.user.domain.User;
import com.gupao.springbootdemo.user.dto.UserDTO;

import java.util.List;
import java.util.stream.Collectors;


/**
 * 类UserConvert.java的实现描述：用户测试表
 * 
 * @author yupeng 2020-06-19 15:00:37
 */
public class UserConvert {

    public static User dto2model(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setAge(userDTO.getAge());
        user.setGmtCreate(userDTO.getGmtCreate());
        user.setGmtModified(userDTO.getGmtModified());
        return  user;
    }

    public static UserDTO model2dto(User user) {
        UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setName(user.getName());
		userDTO.setAge(user.getAge());
		userDTO.setGmtCreate(user.getGmtCreate());
		userDTO.setGmtModified(user.getGmtModified());
        return  userDTO;
    }

    public static List<User> listDto2model(List<UserDTO> userDtoList) {
        return userDtoList.stream().map(p -> dto2model(p)).collect(Collectors.toList());
    }

    public static List<UserDTO> listModel2dto(List<User> userList) {
        return userList.stream().map(p -> model2dto(p)).collect(Collectors.toList());
    }
}
