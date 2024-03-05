package com.example;

public class User implements Cloneable {
    private String name;
    private double height;
    private double length;
    private int gender;
    private Couple cp;

    public User(String name, double height, double length, int gender, Couple cp) {
        this.name = name;
        this.height = height;
        this.length = length;
        this.gender = gender;
        this.cp = cp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Couple getCp() {
        return cp;
    }

    public void setCp(Couple cp) {
        this.cp = cp;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", length=" + length +
                ", gender=" + gender +
                ", cp=" + cp +
                '}';
    }

    // 为啥？重写是为了扩大访问权限，如果不重写，因Object的clone方法的修饰符是protected，除了与Object同包(java.lang)和直接子类能访问，其他类无权访问
    @Override
    protected User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }
}