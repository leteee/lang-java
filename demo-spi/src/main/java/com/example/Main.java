package com.example;

import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {

        String helloWorld = new String("hello world");
        System.out.println(helloWorld == helloWorld.intern());
        ServiceLoader<Animals> animalsIterator = ServiceLoader.load(Animals.class);
        for (Animals a : animalsIterator) {
            System.out.println(a);
        }
    }
}