package com.example;

/**
 * 阿里云SMS实现
 */
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