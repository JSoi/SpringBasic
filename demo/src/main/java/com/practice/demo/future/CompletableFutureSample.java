package com.practice.demo.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureSample {
    public static void main(String[] args) {
        /*Object result = null;
        result = runAsync().join();
        System.out.println("result = " + result);
        
        new Thread(()->
        {
            try {
                Thread.sleep(3000);
                System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    
        new Thread(()->
        {
            try {
                Thread.sleep(5000);
                System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        */
//        allOf();
        thenApply();
    }
    
    private static CompletableFuture<Void> runAsync() { // 반환값이 없는 경우
        return CompletableFuture.runAsync(() -> {
            System.out.println("runAsync");
            try {
                System.out.println("Thread.currentThread().getName() = "
                        + Thread.currentThread().getName());
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
    
    private static CompletableFuture<String> supplyAsync() {
        return CompletableFuture.supplyAsync(() -> {
                    try {
                        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return "Hello";
                }
        );
    }
    
    private static CompletableFuture<String> supplyAsync2() {
        return CompletableFuture.supplyAsync(() -> {
                    try {
                        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return "Hello";
                }
        );
    }
    private static void allOf(){
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(supplyAsync(), supplyAsync2());
        try {
            System.out.println("voidCompletableFuture.get() = " + voidCompletableFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    
    }
    private static void thenApply() {
        // 반환값을 받아 다음 값을 처리
        CompletableFuture<String> stringCompletableFuture = supplyAsync().thenApply(stringRes -> stringRes + "test");
        String thenApplyRes = null;
        try {
            thenApplyRes = stringCompletableFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("thenApplyRes = " + thenApplyRes);
    
    }
    private static void thenAccept(){
        // 반환값을 사용하나
    }
}
