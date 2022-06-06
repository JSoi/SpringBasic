package com.sparta.springcore.controller;

import com.sparta.springcore.dto.ItemDto;
import com.sparta.springcore.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemSearchController {

    // Controller 가 자동으로 해주는 일
// 1. API Request 의 파라미터 값에서 검색어 추출 -> query 변수
// 5. API Response 보내기
// 5.1) response 의 header 설정
// 5.2) response 의 body 설정
    private final ItemService itemService;

    @GetMapping("/api/search")
    @ResponseBody
    public List<ItemDto> getItems(@RequestParam String query) throws IOException {
        return itemService.getItems(query);
    }
}