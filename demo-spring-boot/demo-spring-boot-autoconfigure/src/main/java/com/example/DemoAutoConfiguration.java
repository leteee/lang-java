package com.example;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


/**
 * https://cloud.tencent.com/developer/article/2292258
 */
@AutoConfiguration
@ConditionalOnClass(SmsTemplate.class)
@EnableConfigurationProperties(value = SmsProperties.class)
public class DemoAutoConfiguration {

    private ApplicationContext context;
    private SmsProperties smsProperties;

    public DemoAutoConfiguration(ApplicationContext context, SmsProperties smsProperties) {
        this.context = context;
        this.smsProperties = smsProperties;
    }

    @Bean
    @ConditionalOnMissingBean
    public SmsTemplate smsTemplate() {
        return new SmsTemplate(context, smsProperties);
    }

    @Bean
    public SmsService ali() {
        return new AliCloudSmsServiceImpl();
    }

    @Bean
    public SmsService tx() {
        return new TxCloudSmsServiceImpl();
    }

    @Bean
    public SmsService ymx() {
        return new YmxCloudSmsServiceImpl();
    }
}