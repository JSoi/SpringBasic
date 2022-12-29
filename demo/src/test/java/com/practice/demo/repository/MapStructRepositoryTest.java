package com.practice.demo.repository;

import com.practice.demo.converter.Converter;
import com.practice.demo.dto.MapstructDto;
import com.practice.demo.entity.MapStructEntity;
import com.practice.demo.entity.MapStructEntityV2;
import com.practice.demo.entity.TestV1;
import com.practice.demo.entity.TestV2;
import com.practice.demo.mapper.MapStructMapper;
import com.practice.demo.mapper.MapStructMapperImpl;
import com.practice.demo.mapper.MapStructMapperSpec;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MapStructRepositoryTest {
    @Autowired
    private MapStructRepository mapStructRepository;
    @Autowired
    private MapStructRepositoryV2 mapStructRepositoryV2;
    
    @Test
    void testInsert() {
        MapStructMapper mapStructMapper = new MapStructMapperImpl();
        MapStructEntity mapStructEntity = MapStructEntity.builder()
                .description(TestV1.TEST)
                .build();
        mapStructRepository.save(mapStructEntity);
        MapstructDto dtoRes = mapStructMapper.toDto(mapStructEntity);
        System.out.println("dtoRes = " + dtoRes);
        
        MapStructEntityV2 mapStructEntityV2 = new MapStructEntityV2();
        mapStructEntityV2.setDescription(TestV2.VERSION);
        mapStructRepositoryV2.save(mapStructEntityV2);
    }
    
    @Test
    void testQuery() {
        List<MapStructEntity> anEnum = mapStructRepository.getEnum(TestV1.TEST);
        System.out.println("anEnum = " + anEnum);
        
        List<MapStructEntityV2> anEnum2 = mapStructRepositoryV2.getEnum(TestV2.VERSION);
        System.out.println("anEnum2 = " + anEnum2);
    }
    
    @Test
    void testDtoMapping() {
        MapstructDto test = MapstructDto.builder()
                .description("UNIQUE")
                .build();
        MapStructMapperSpec mapStructMapperSpec = MapStructMapperSpec.INSTANCE;
        MapStructEntity mapStructEntity = mapStructMapperSpec.toEntity(test);
        MapstructDto mapstructDto = mapStructMapperSpec.toDto(mapStructEntity);
        System.out.println("mapstructDto = " + mapstructDto);
        System.out.println("mapStructEntity = " + mapStructEntity);
    }
    
    @Test
    void testConverter(){
        MapstructDto test = MapstructDto.builder()
                .description("UNIQUE")
                .build();
        MapStructEntity convert = Converter.convert(test);
        System.out.println("convert = " + convert);
    }
}