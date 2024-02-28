package com.example;

import java.util.concurrent.TimeUnit;

/**
 * java.Lang.OutOfMemoryError: unable to create new native thread
 */
public class MetaspaceDemo {
    public static void main(String[] args) {
        for (int i = 1; ; i++) {
            System.out.println("i = " + i);
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "" + i).start();
        }
    }
}