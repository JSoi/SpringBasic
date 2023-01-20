package com.practice.demo.java;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

public class StreamPracticeTest {
    @Test
    void intStream(){
        IntStream.range(1,100)
                .filter(i -> i % 2 == 0)
                .forEach(System.out::println);
    }
    
    @Test
    void deprecatedVersion(){
        int[] arr = new int[]{1, 2, 3, 4, 5};
        
    }
    @Test
    void intStreamBoxed() {
        IntStream.range(1, 10).boxed()
                .filter(i -> i % 2 == 0) // 짝수인 것들만
                .map(i -> i * 2)
                .reduce(Integer::sum)
                .ifPresent(System.out::println);
    }
}
