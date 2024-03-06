package com.example;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author lixiang
 * @date 2023/5/16 09:27
 */
@ComponentScan
@AutoConfiguration
@ConditionalOnClass(SmsTemplate.class)
@EnableConfigurationProperties(value = SmsProperties.class)
public class SmsAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public SmsTemplate smsTemplate(){
        return new SmsTemplate();
    }

}