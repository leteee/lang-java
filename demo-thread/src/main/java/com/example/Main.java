package com.example;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread t1 = new MyThread();
        Thread t2 = new Thread(new RunnableThread());
        ExecutorService executorService = Executors.newCachedThreadPool();
        t1.start();
        t2.start();
        Future<String> r3 = executorService.submit(new CallableThread());
        System.out.println(r3.get());
    }
}