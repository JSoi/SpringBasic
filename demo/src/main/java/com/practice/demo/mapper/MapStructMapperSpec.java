package com.practice.demo.mapper;

import com.practice.demo.dto.MapstructDto;
import com.practice.demo.entity.MapStructEntity;
import com.practice.demo.entity.TestV1;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MapStructMapperSpec {
    MapStructMapperSpec INSTANCE = Mappers.getMapper(MapStructMapperSpec.class);
    @Mapping(target="id", ignore=true)
    @Mapping(target="description", constant= "UNIQUE")
    @Mapping(source="zonedDateTime",target="time")
    MapStructEntity toEntity(MapstructDto dto);
    
    @Mapping(target = "description", constant = "TEST")
    @Mapping(source="time",target="zonedDateTime")
    MapstructDto toDto(MapStructEntity entity);
}
