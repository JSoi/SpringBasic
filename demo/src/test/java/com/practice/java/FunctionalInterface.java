package com.practice.java;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionalInterface {
    public <T,R> List<R> apply(T t, Function<T,R> function){ // 함수의 행동이 정의되어야 한다.
        List<R> myList = new ArrayList<>();
        myList.add(function.apply(t));
        return myList;
    }
    @Test
    void test(){
        List<Integer> test = apply("test", String::length);
        System.out.println("test = " + test);
    }
}
