package com.practice.demo.service;

import com.practice.demo.mvc.entity.TransactionEntity;
import com.practice.demo.mvc.repository.TransactionRepository;
import com.practice.demo.mvc.service.TransactionService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootTest
class TransactionServiceTest {
    @Autowired
    private TransactionService transactionService;
    
    @Autowired
    private TransactionRepository transactionRepository;
    
    @Test
    void txTest() {
        transactionService.dataInsert();
        String updateName = "testName";
        transactionService.updateAllNames("testName");
        Assertions.assertThat(transactionRepository.findAll()
                .stream().map(TransactionEntity::getName).distinct().count()).isEqualTo(1);
    }
    
    @Test
    void dirtyCheckingTest() {
        transactionService.findAndUpdate("name1");
    }
    
    @Test
    void checkAllEntity() {
        transactionRepository.findAll().forEach(System.out::println);
    }
    
    @Test
    @Transactional
    void checkParentChildTransaction() {
        transactionService.parentTransaction();
        transactionRepository.findAll().forEach(System.out::println);
        System.out.println(" = ");
    }
    
    @Test
    void testAsyncExecutor() {
        IntStream.range(0, 10).forEach(
                a -> {
                    System.out.println("a = " + a);
                    transactionService.testAsync();
                }
        );
        
    }
    
    @Test
    void testStreamGroupingBy() {
        // 다섯 개씩 쪼개줘야 한다
        // 각 심볼마다 5개, 5개, 3개
        Node a = new Node("a", "1");
        Node b = new Node("b", "2");
        Node c = new Node("c", "3");
        Node d = new Node("d", "4");
        Node e = new Node("e", "5");
        Node f = new Node("f", "6");
        Node g = new Node("g", "7");
        Node h = new Node("h", "8");
        Node i = new Node("i", "9");
        ArrayList<Object> objects = new ArrayList<>(List.of(a, b, c, d, e, f, g, h, i));
        getListSeperated(objects, 2).forEach(System.out::println);
    }
    private <T> Collection<List<T>> getListSeperated(List<T> target, int size) {
        AtomicInteger counter = new AtomicInteger(0);
        return target.stream()
                .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / size))
                .values();
    }
    
    static class Node {
        public Node(String index, String name) {
            this.index = index;
            this.name = name;
        }
        
        private String index;
        private String name;
        
        @Override
        public String toString() {
            return "index = " + index + ", name = " + name;
        }
    }
    
}