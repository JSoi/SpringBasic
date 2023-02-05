package jpabook.jpashop;

import jakarta.persistence.*;
import jpabook.jpashop.purejpa.entity.PureEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
public class SimpleJPATest {
//    @Autowired
//    LocalContainerEntityManagerFactoryBean nativeEntityManagerFactory;
    @PersistenceContext
    EntityManager em;
    @Test
    @Transactional
    void dirtyChecking() {
        PureEntity pureEntity1 = PureEntity.builder()
                .id(101L)
                .age(20)
                .name("test1")
                .build();
        em.persist(pureEntity1);
//        em.flush();
        System.out.println("=======bf commit=======");
        PureEntity pureEntity =
                Optional.ofNullable(em.find(PureEntity.class, 101L))
                        .orElseThrow(()-> new IllegalArgumentException("jjjjj found"));
        pureEntity.setName("test2");
    
        System.out.println("=======bf commit=======");
        System.out.println("=======af commit=======");
        em.close();
    }
}