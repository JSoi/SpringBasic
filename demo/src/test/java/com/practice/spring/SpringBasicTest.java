package com.practice.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class SpringBasicTest {
    @Test
    void iocTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
        Object customBean = ac.getBean("customBean");
        CustomBean customBean1 = ac.getBean("customBean", CustomBean.class);
        System.out.println("customBean1.getBeanDescription() = " + customBean1.getBeanDescription());
        System.out.println("customBean.toString() = " + customBean.toString());
    }
    
    @Test
    void testTransactionalProxy(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        System.out.println("annotationConfigApplicationContext = " + annotationConfigApplicationContext);
    }
    
    @Configuration
    static class Config {
        @Bean
        public CustomBean customBean() {
            return new CustomBean("name", "description");
        }
    }
    
    public static class CustomBean {
        public CustomBean(String beanName, String beanDescription) {
            this.beanName = beanName;
            this.beanDescription = beanDescription;
        }
    
        public String getBeanName() {
            return beanName;
        }
    
        public String getBeanDescription() {
            return beanDescription;
        }
    
        private String beanName;
        private String beanDescription;
    }
    @Service
    public class TransactionService{
        public void nonTransactional(){
            System.out.println("This is pure nonTransactional");
        }
        public void callTransactional(){
            transactional();
        }
        @Transactional
        public void transactional(){
            System.out.println("This is Transactional");
        }
    }
    @Service
    public class CallTransactionService{
        @Autowired
        private TransactionService transactionService;
        
        public void callNonTransactionalFromOther(){
            transactionService.nonTransactional();
        }
        public void callTransactionalFromOther(){
            transactionService.callTransactional();
        }
    }
}
