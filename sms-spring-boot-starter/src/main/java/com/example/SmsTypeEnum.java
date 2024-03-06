package com.example;

public enum SmsTypeEnum {
    //阿里云
    ALI_CLOUD("ali"),
    //腾讯云
    TX_CLOUD("tx"),
    //亚马逊云
    YMX_CLOUD("ymx");

    private String type;

    SmsTypeEnum(String type) {}

}