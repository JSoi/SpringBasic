package com.jsoi.week04.utils;

import com.jsoi.week04.domain.ItemDto;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class NaverShopSearch {
    public String search(String keyword) {
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.add("X-Naver-Client-Secret", "_vjHHYh4j2");
        headers.add("X-Naver-Client-Id", "u37MwB_R7fOuSv1rJDhT");
        String body = "";

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        ResponseEntity<String> responseEntity = rest.exchange("https://openapi.naver.com/v1/search/shop.json?query=" + keyword, HttpMethod.GET, requestEntity, String.class);
        HttpStatus httpStatus = responseEntity.getStatusCode();
        int status = httpStatus.value();
        String response = responseEntity.getBody();
        System.out.println("Response status: " + status);
        System.out.println(response);
        return response;
    }

    public List<ItemDto> fromJsontoItems(String result) {
        JSONObject rjson = new JSONObject(result);
        JSONArray items = rjson.getJSONArray("items");
        List<ItemDto> res = new ArrayList<>();
        for (int i = 0; i < items.length(); i++) {
            res.add(new ItemDto(items.getJSONObject(i)));
        }
        return res;


    }

}
