package com.practice.demo.mvc.service;

import com.practice.demo.mvc.entity.TransactionEntity;
import com.practice.demo.mvc.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.concurrent.Executor;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final Executor executor;
    private final TransactionRepository transactionRepository;
//    @Transactional
    public void updateAllNames(String updateName){
        transactionRepository.findAll().forEach(
                transactionEntity -> {
                    transactionEntity.updateName(updateName);
                }
        );
    }
    public void dataInsert(){
        transactionRepository.deleteAll();
        IntStream.range(0,10).forEach(
                i -> {
                    transactionRepository.save(TransactionEntity.builder()
                            .name("name" + i)
                            .description("description" + i)
                            .build());
                }
        );
    }
    @Transactional
    public void findAndUpdate(String name){
        TransactionEntity target = transactionRepository.findByName("name1").orElseThrow(
                ()-> new IllegalArgumentException("not found")
        );
        target.updateName("newName");
        System.out.println("target = " + target.getName());
        transactionRepository.findByName("newName").ifPresent(
                d -> {
                    System.out.println("transactionEntity = " + d.getName());
                }
        );
        System.out.println("now!");
    }
    
    @Transactional
    public void parentTransaction(){
        
        transactionRepository.findByName("name1").ifPresent(
                d -> {
                    d.updateName("newName");
                }
        );
        transactionRepository.findAll().forEach(
                this::childTransaction
        );
        System.out.println("transactionRepository = " + transactionRepository);
    }
    @Async
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void childTransaction(TransactionEntity transactionEntity){
        transactionEntity.updateName("newName");
        throw new RuntimeException();
//        System.out.println("transactionEntity = " + transactionEntity);
    }
    
    public void testAsync(){
        Runnable runnable = () -> {
            System.out.println("thread = " + Thread.currentThread().getName());
        };
        executor.execute(runnable);
    }
    
}
