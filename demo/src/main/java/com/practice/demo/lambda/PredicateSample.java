package com.practice.demo.lambda;

import io.micrometer.observation.Observation;
import org.junit.Test;
import org.springframework.boot.context.properties.bind.Nested;

import java.util.List;
import java.util.function.Consumer;

public class PredicateSample {
    @Test
    public void consumer(){
        java.util.function.Consumer<? super String> consumer = a -> System.out.println("a = " + a);
        List<String> stList = List.of("hi", "myname");
        stList.forEach(consumer);
    }
}
