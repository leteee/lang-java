package com.example;

import java.nio.ByteBuffer;

/**
 * java.lang.OutOfMemoryError: Direct buffer memory 演示
 * JVM参数配置：-Xms10m -Xmx10m -XX:+PrintGCDetails  -XX:MaxDirectMemorySize=5m
 */
public class DirectBufferMemoryDemo {
    public static void main(String[] args) {
        //最大5M 申请6M
        ByteBuffer bb = ByteBuffer.allocateDirect(6 * 1024 * 1024);

    }
}