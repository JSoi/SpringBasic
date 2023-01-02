package com.practice.demo.mapper;

import com.practice.demo.annotation.Arg;
import com.practice.demo.dto.ArgDto;
import com.practice.demo.entity.ArgEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArgMapper {
    ArgMapper INSTANCE = Mappers.getMapper(ArgMapper.class);
//    @Mapping(target = "id", ignore = true)
    ArgDto toDto(ArgEntity arg);
    
    ArgEntity toEntity(ArgDto argDto) ;
}
