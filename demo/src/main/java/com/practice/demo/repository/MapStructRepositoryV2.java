package com.practice.demo.repository;

import com.practice.demo.entity.MapStructEntity;
import com.practice.demo.entity.MapStructEntityV2;
import com.practice.demo.entity.TestV2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MapStructRepositoryV2 extends JpaRepository<MapStructEntityV2, Long> {
    
    @Query("select m from MapStructEntityV2 m where m.description=:test")
    List<MapStructEntityV2> getEnum(TestV2 test);
}
