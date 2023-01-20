package com.practice.demo.mvc.repository;

import com.practice.demo.mvc.entity.MapStructEntity;
import com.practice.demo.mvc.entity.TestV1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MapStructRepository extends JpaRepository<MapStructEntity, Long> {
    @Query("select m from MapStructEntity m where m.description=:test")
    List<MapStructEntity> getEnum(TestV1 test);
}
