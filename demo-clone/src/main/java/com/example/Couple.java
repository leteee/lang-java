package com.example;

public class Couple {
    private String name;
    private int gender;

    public Couple(String name, int gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Couple{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }
}