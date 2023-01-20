package com.practice.demo.mvc.mapper;

public interface EntityMapper<D, E> {
    E toEntity(D dto);
    D toDto(E entity);
}
