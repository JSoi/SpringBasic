package com.practice.demo.reflection;

public abstract class Animal implements Eating {
    public static String CATEGORY = "domestic";
    public String name;

    protected abstract String getSound();
}
