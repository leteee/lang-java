package com.example;

import org.springframework.context.ApplicationContext;

/**
 * @author lixiang
 * @date 2023/5/16 09:33
 */
public class SmsTemplate {
    private ApplicationContext context;

    private SmsProperties smsProperties;

    public SmsTemplate(ApplicationContext context, SmsProperties smsProperties) {
        this.context = context;
        this.smsProperties = smsProperties;
    }

    public String send(String fromPhone, String toPhone, String content) {
        //获取云厂商的业务实现类
        String type = smsProperties.getType();
        SmsService smsService = (SmsService) context.getBean(type);
        return smsService.send(fromPhone, toPhone, content);
    }
}