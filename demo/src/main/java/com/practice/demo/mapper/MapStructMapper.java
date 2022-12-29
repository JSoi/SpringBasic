package com.practice.demo.mapper;

import com.practice.demo.dto.MapstructDto;
import com.practice.demo.entity.MapStructEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructMapper extends EntityMapper<MapstructDto,MapStructEntity>{

}
