package com.example;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Couple cp = new Couple("张小小", 0);
        User user = new User("老王", 180.0, 18.0, 1, cp);
        User cloneUser = user.clone();
        cloneUser.setName("张三");
        cloneUser.setGender(0);
        cp.setName("张中中");
        System.out.println(user + "\n" + cloneUser);
    }

    private static void m1() throws CloneNotSupportedException {
        Couple cp = new Couple("张小小", 0);
        User user = new User("老王", 180.0, 18.0, 1, cp);
        System.out.println("克隆之前的老王===================");
        System.out.println(user);

        // 克隆老王
        User newUser = user.clone();
        System.out.println("克隆出来的新老王=================");
        System.out.println(newUser);

        // 改变老王cp信息的值及个人信息
        user.setName("老王爱花姑娘");
        user.setGender(0);
        cp.setGender(1);

        System.out.println("发生变化之后的旧老王================");
        System.out.println(user);
        System.out.println("发生变化之后的新老王================");
        System.out.println(newUser);
    }
}