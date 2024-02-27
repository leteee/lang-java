package com.example;

public class Cat implements Animals {
    static {
        System.out.println("hello world cat");
    }

    @Override
    public void run() {
        System.out.println("cat is running");
    }

    @Override
    public void eat() {
        System.out.println("cat is eating");
    }
}