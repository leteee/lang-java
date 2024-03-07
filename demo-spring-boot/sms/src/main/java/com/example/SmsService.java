package com.example;

public interface SmsService {
    String send(String fromPhone,String toPhone,String content);
}