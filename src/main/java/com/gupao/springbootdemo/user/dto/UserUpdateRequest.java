package com.gupao.springbootdemo.user.dto;


import com.gupao.springbootdemo.user.domain.User;
import lombok.Data;

@Data
public class UserUpdateRequest {

    private User user;

    private Long userId;
}
