package com.practice.demo.mvc.mapper;

import com.practice.demo.mvc.dto.MapstructDto;
import com.practice.demo.mvc.entity.MapStructEntity;
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
