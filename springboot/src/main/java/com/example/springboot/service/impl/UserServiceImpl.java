package com.example.springboot.service.impl;

import com.example.springboot.entity.User;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.service.IUserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> list(String nickname) {
        return userMapper.list(nickname);
    }

    @Override
    public List<User> page(String nickname, Integer pageNum, Integer pageSize) {
        List<User> data = PageHelper.startPage(pageNum, pageSize).doSelectPage(() -> userMapper.list(nickname));
        return data;
    }
}
