package com.example;

import java.util.concurrent.Callable;

public class CallableThread implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "名称" + Thread.currentThread().getName() + "的线程ID是：" + Thread.currentThread().getId();
    }
}
