package com.example.service;

import com.example.SmsService;
import org.springframework.stereotype.Service;

/**
 * 阿里云SMS实现
 */
@Service("ali")
public class AliCloudSmsServiceImpl implements SmsService {

    @Override
    public String send(String fromPhone, String toPhone, String content) {
        System.out.println("------------------当前SMS厂商为阿里云------------------");
        System.out.println("----"+fromPhone+" 向 "+toPhone +" 发送了一条短信。"+"----");
        System.out.println("短信内容为："+content);
        System.out.println("----------------------------------------------------");
        return "success";
    }
}