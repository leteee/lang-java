package com.example;

public class Main {
    public static void main(String[] args) {
        String s1 = new StringBuilder().append("think").append("123").toString();
        System.out.println(s1.intern() == s1);
        String s2 = new StringBuilder().append("ja").append("va").toString();
        System.out.println(s2.intern() == s2);
        System.out.println("Hello world!");
    }
}