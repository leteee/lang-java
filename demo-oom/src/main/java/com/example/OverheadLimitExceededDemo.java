package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * GC overhead limit exceeded
 * JVM参数设置：8U
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 */
public class OverheadLimitExceededDemo {
    public static void main(String[] args) {
        int i = 0;
        final List list = new ArrayList();

        while (true) {
            list.add(String.valueOf(++i).intern());
        }
    }
}
