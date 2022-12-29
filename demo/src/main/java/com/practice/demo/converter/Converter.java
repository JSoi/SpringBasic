package com.practice.demo.converter;

import com.practice.demo.dto.MapstructDto;
import com.practice.demo.entity.MapStructEntity;
import com.practice.demo.entity.TestV1;

public class Converter {
    public static MapstructDto convert(MapStructEntity mapStructEntity) {
        return MapstructDto.builder()
                .id(mapStructEntity.getId())
                .description(mapStructEntity.getDescription().name())
                .zonedDateTime(mapStructEntity.getTime())
                .build();
    }
    
    public static MapStructEntity convert(MapstructDto mapStructDto) {
        return MapStructEntity.builder()
                .description(TestV1.valueOf(mapStructDto.getDescription()))
                .time(mapStructDto.getZonedDateTime())
                .build();
    }
}
