package com.example;

import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {
        ServiceLoader<Animals> animalsIterator = ServiceLoader.load(Animals.class);
        for (Animals a : animalsIterator) {
            System.out.println(a);
        }
    }
}