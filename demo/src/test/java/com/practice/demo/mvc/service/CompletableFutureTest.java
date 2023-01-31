package com.practice.demo.mvc.service;

import java.time.ZonedDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest {
    
    private static String randomErrorMethod() {
        double random = Math.random() * 10;
        
        System.out.println("random = " + random);
        
        if (random != 0) throw new IllegalStateException("꽝입니다");
        else return random + "";
        
    }
    
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(ZonedDateTime.now());
//        CompletableFuture<String> stringCompletableFuture = getFuture1(3000, "daeho")
//                .thenCombine(getFuture2(2000, "ISSAC"), (name1, name2) -> name1 + ":" + name2);
    
//        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.anyOf(getFuture1(3000, "daeho"), getFuture2(2000, "ISSAC"))
//                .thenAccept(System.out::println);
//        voidCompletableFuture.thenAccept(s -> System.out.println("s = " + s)).join();
//        System.out.println("fin");
//        CompletableFuture<String> exceptionally;
//        CompletableFuture.completedFuture(getExceptionalFutureWrapper())
//                .exceptionally(throwable -> {
//                    System.out.println("throwable = " + throwable);
//                    return "GOOD";
//                })
//                .thenAccept(System.out::println);
    
        boolean flag = CompletableFuture.completedFuture(getExceptionalFuture(false))
                .completeExceptionally(new IllegalStateException("goodoooooo"));
        System.out.println("flag = " + flag);
        System.out.println(ZonedDateTime.now());
        
    }
    private static String getExceptionalFutureWrapper() {
        try {
            return getExceptionalFuture(false);
        } catch (Exception e) {
//            throw new IllegalStateException("진짜짜짜짜ㅏ");
            return "GOOD";
        }
        
    }
    private static String getExceptionalFuture(boolean flag){
        if(!flag){
            throw new IllegalStateException("꽝입니다");
        }
        return "성공";
    }
    
    
    private static CompletableFuture<String> getFuture1(int millis, String name) {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return name;
        });
        return future1;
    }
    
    private static CompletableFuture<String> getFuture2(int millis, String name) {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return name;
        });
        return future1;
    }
    
    
}



