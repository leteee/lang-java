package com.example;

public class Main {
    public static void main(String[] args) {
        //关键点是jdk7+ 常量池中可以直接存储堆中的引用。因此常量池中存放的是引用，这份引用指向 s1 引用的对象。 也就是说引用地址是相同的
        String s1 = new StringBuilder().append("think").append("123").toString();
        System.out.println(s1.intern() == s1);
        String s2 = new StringBuilder().append("ja").append("va").toString();
        System.out.println(s2.intern() == s2);
        System.out.println("Hello world!");
    }
}