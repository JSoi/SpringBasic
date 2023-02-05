package com.practice.demo.mvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.demo.mvc.dto.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.mapstruct.ap.internal.util.Collections;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/json/controller")
public class JsonController {
    @GetMapping
    public void printJSON(@RequestParam JSONArray batchOrders) throws JsonProcessingException, ParseException {
        System.out.println("JsonController.printJSON");
        System.out.println("batchOrders = " + batchOrders);
        JsonReflections(batchOrders);
    }
    
    @GetMapping("/string")
    public void printJSONStr(@RequestParam String batchOrders) throws JsonProcessingException {
        System.out.println("JsonController.printJSONStr");
        System.out.println("batchOrders = " + batchOrders);
        ObjectMapper objectMapper = new ObjectMapper();
        Position.Node[] node = objectMapper.readValue(batchOrders, Position.Node[].class);
        System.out.println("node = " + node);
    }
    
    private <T> void JsonReflections(T src) throws JsonProcessingException, ParseException {
        if(src.getClass().getTypeName().equals(JSONArray.class.getTypeName())){
            JSONArray jsonArr = (JSONArray) src;
            System.out.println("This is jsonArray = " + src);
            ObjectMapper mapper = new ObjectMapper();
            mapper.createObjectNode();
            
            JsonNode jsonNode = mapper.readTree(String.valueOf(jsonArr));
            parseJsonNode(jsonNode);
        }
    }
    
    // { %7b
    // } %7d
    // [ %5b
    // ] %5d
    private String parseJsonNode(JsonNode jsonNode) throws JsonProcessingException {
        StringBuilder sb = new StringBuilder();
        sb.append("%5b");
        for (int i = 0 ; i < jsonNode.size(); i++) {
            JsonNode node = jsonNode.get(i);
            System.out.println("node = " + node);
            if(node.isArray()){
                System.out.println("ARRRRRRAAAAYYY;");
                List<String> list = new ArrayList<>();
                for (JsonNode childNode : node) {
                    list.add(parseJsonNode(childNode));
                }
                String collect = list.stream().collect(Collectors.joining(","));
                sb.append(collect);
            }else {
                String s = node.toString();
                s = s.replace("[", "");
                s = s.replace("]", "");
                s = s.replace("{", "");
                s = s.replace("}", "");
                
                s = s.replace("\\", "");
                
                s = s.replace("\"\\", "%22");
                sb.append("%7b").append(s).append("%7d");
                sb.append(s);
            }
        }
        sb.append("%5d");
        System.out.println("sb.toString() = " + sb);
        return sb.toString();
    }
    
}
