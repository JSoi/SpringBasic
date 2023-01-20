package com.practice.demo.mvc.mapper;

import com.practice.demo.mvc.dto.ArgDto;
import com.practice.demo.mvc.entity.ArgEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArgMapper {
    ArgMapper INSTANCE = Mappers.getMapper(ArgMapper.class);
//    @Mapping(target = "id", ignore = true)
    ArgDto toDto(ArgEntity arg);
    
    ArgEntity toEntity(ArgDto argDto) ;
}
