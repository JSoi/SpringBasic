package com.practice.demo.mvc.mapper;

import com.practice.demo.mvc.dto.MapstructDto;
import com.practice.demo.mvc.entity.MapStructEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructMapper extends EntityMapper<MapstructDto, MapStructEntity>{

}
