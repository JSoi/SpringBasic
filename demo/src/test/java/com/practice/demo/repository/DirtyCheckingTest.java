package com.practice.demo.repository;

import com.practice.demo.mvc.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DirtyCheckingTest {
    @Autowired
    private TransactionRepository transactionRepository;
    
    @Test
    void testTransaction(){
    }
}
