package com.practice.java;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;

public class StreamPracticeTest {
    @Test
    void formatApple(){
        List<Apple> inventory = List.of(new Apple("name1","purple", 80), new Apple("name2","red", 155), new Apple("name3","green", 120));
        inventory.stream()
                .filter((Apple a) -> a.weight > 100)
//                .sorted(( a1, a2) -> a1.weight-a2.weight)
                .map(a->a.color)
                .forEach(System.out::println);
    }
    @Test
    void sortTest(){
        List<Apple> inventory = new ArrayList<>(List.of(new Apple("name1","purple", 80),
                new Apple("name2","red", 155),
                new Apple("name4","aaa", 120),
                new Apple("name3","green", 120)));
        inventory.sort(comparing(Apple::getWeight).thenComparing(Apple::getColor));
        System.out.println("inventory = " + inventory);
    }
    
    void applePrintTest(){
        List<Apple> inventory = new ArrayList<>(List.of(new Apple("name1","purple", 80),
                new Apple("name2","red", 155),
                new Apple("name4","aaa", 120),
                new Apple("name3","green", 120)));
        
    }
    
    
    // 기타 설정 및 클래스
    
    public void prettyPrintApple(List<Apple> inventory, AppleFormatter appleFormatter) {
        for (Apple apple : inventory) {
            String output = appleFormatter.formatApple(apple);
            System.out.println(output);
        }
    
    }
    public static class Apple {
        public Apple(String name, String color, int weight) {
            this.name = name;
            this.color = color;
            this.weight = weight;
        }
    
        public String getName() {
            return name;
        }
    
        public String getColor() {
            return color;
        }
    
        public int getWeight() {
            return weight;
        }
    
        String name;
        String color;
        int weight;
        @Override
        public String toString(){
            return "name: "+name+", color: "+color+", weight: "+weight;
        }
    }
    public interface AppleFormatter{
        String formatApple(Apple apple);
    }
    public class AppleFormatterV1 implements  AppleFormatter{
        @Override
        public String formatApple(Apple apple) {
            return String.format("V1 name : %s, color : %s, weight : %d", apple.name, apple.color, apple.weight);
        }
    }
    
    public class AppleFormatterV2 implements  AppleFormatter{
        @Override
        public String formatApple(Apple apple) {
            return String.format("V2 name : %s, color : %s, weight : %d", apple.name, apple.color, apple.weight);
        }
    }
    

}
