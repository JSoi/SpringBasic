package com.practice.demo.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class PublicApiRequestDto {
    private String key;
    private String type;
    private String service;
    private Integer startIndex;
    private Integer endIndex;
}

