package com.example.springboot.controller;

import com.example.springboot.entity.R;
import com.example.springboot.entity.User;
import com.example.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService iUserService;
    @GetMapping("/list")
    public R list(){
        List<User> data = iUserService.list();
        return R.success(data);
    }
}
