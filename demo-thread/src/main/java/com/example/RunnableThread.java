package com.example;

public class RunnableThread implements Runnable {
    @Override
    public void run() {
        System.out.println("名称" + Thread.currentThread().getName() + "的线程ID是：" + Thread.currentThread().getId());
    }
}
