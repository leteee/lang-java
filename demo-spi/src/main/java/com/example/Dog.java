package com.example;

public class Dog implements Animals {
    static {
        System.out.println("hello world dog");
    }

    @Override
    public void run() {
        System.out.println("dog is running");
    }

    @Override
    public void eat() {
        System.out.println("dog is eating");
    }
}