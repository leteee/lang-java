package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * @author lixiang
 * @date 2023/5/16 09:33
 */
public class SmsTemplate {

    @Autowired
    private SmsProperties smsProperties;

    @Autowired
    private ApplicationContext context;

    public String send(String fromPhone, String toPhone, String content) {
        //获取云厂商的业务实现类
        String type = smsProperties.getType();
        SmsService smsService = (SmsService) context.getBean(type);
        return smsService.send(fromPhone, toPhone, content);
    }
}