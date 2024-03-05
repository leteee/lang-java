package com.example.springboot.controller;

import com.example.springboot.entity.R;
import com.example.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    IUserService iUserService;

    @GetMapping("")
    public R list() {
        return R.success("hello world!");
    }
}
