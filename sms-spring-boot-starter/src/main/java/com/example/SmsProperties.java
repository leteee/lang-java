package com.example;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "sms.server")
public class SmsProperties {

    /**
     * 发送短信类型
     */
    private String type;

    public String getType() {
        if(type == null || "".equals(type)){
            type = SmsTypeEnum.ALI_CLOUD.name();
        }
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}