package com.practice.demo.mvc.dto;

import com.practice.demo.mvc.annotation.ArgReq;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@ArgReq
public class ArgDto {
    String userId;
    String name;
}
