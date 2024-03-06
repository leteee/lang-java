package com.example.springboot.controller;

import com.example.SmsTemplate;
import com.example.springboot.entity.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/starter")
public class StarterController {

    @Autowired
    SmsTemplate smsTemplate;

    @GetMapping("")
    public R list() {
        String msg = smsTemplate.send("110", "119", "这里着火了，请求支援！！");
        return R.success(msg);
    }
}
