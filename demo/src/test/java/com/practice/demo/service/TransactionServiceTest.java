package com.practice.demo.service;

import com.practice.demo.mvc.entity.TransactionEntity;
import com.practice.demo.mvc.repository.TransactionRepository;
import com.practice.demo.mvc.service.TransactionService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TransactionServiceTest {
    @Autowired
    private TransactionService transactionService;
    
    @Autowired
    private TransactionRepository transactionRepository;
    @Test
    void txTest(){
        transactionService.dataInsert();
        String updateName = "testName";
        transactionService.updateAllNames("testName");
        Assertions.assertThat(transactionRepository.findAll()
                .stream().map(TransactionEntity::getName).distinct().count()).isEqualTo(1);
    }
    
    @Test
    void dirtyCheckingTest(){
        transactionService.findAndUpdate("name1");
    }
    
    @Test
    void checkAllEntity(){
        transactionRepository.findAll().forEach(System.out::println);
    }
}