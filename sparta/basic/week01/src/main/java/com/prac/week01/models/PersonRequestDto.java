package com.prac.week01.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PersonRequestDto {
    private String name;
    private int age;
    private String job;
}
