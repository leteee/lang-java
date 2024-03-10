package com.example.springboot.service.impl;

import com.example.springboot.entity.User;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.service.IUserService;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
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

//    @Transactional(rollbackFor = Exception.class)
    @Transactional()
    @Override
    public void mysqlLock(String tid) {
        try {
            log.info("事务{}-开始", tid);
            userMapper.updateNicknameById(2, "mike");
            log.info("事务{}-执行完成", tid);
            Thread.sleep(1000 * 10);
            log.info("事务{}-完成", tid);
        } catch (InterruptedException e) {
            log.error("事务{}-报错", e);
            throw new RuntimeException(e);  // 抛出RuntimeException异常才能回滚事务
        }
    }

}
