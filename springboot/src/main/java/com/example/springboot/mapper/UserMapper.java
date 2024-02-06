package com.example.springboot.mapper;

import com.example.springboot.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<User> list(String nickname);
}
