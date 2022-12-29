package com.practice.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MapstructDto {
    private Long id;
    private String description;
    private ZonedDateTime zonedDateTime;
    
}
