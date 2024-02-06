package com.example.springboot.service;

import com.example.springboot.entity.User;

import java.util.List;

public interface IUserService {
    List<User> list(String nickname);

    List<User> page(String nickname, Integer pageNum, Integer pageSize);
}
