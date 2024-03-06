package com.example.service;

import com.example.SmsService;
import org.springframework.stereotype.Service;

/**
 * 亚马逊云SMS实现
 * @author lixiang
 * @date 2023/5/16 09:42
 */
@Service("ymx")
public class YmxCloudSmsServiceImpl implements SmsService {
    @Override
    public String send(String fromPhone, String toPhone, String content) {
        System.out.println("------------------当前SMS厂商为亚马逊云------------------");
        System.out.println("----"+fromPhone+" 向 "+toPhone +" 发送了一条短信。"+"----");
        System.out.println("短信内容为："+content);
        System.out.println("----------------------------------------------------");
        return "success";
    }
}