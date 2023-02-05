package com.practice.demo.mvc.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.json.simple.JSONArray;

@Data
@AllArgsConstructor
@Builder
public class Position {
    JSONArray batchOrder;
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Node{
        private String symbol;
        private String side;
        private String positionSide;
        private String type;
        private String quantity;
    }
    
}
