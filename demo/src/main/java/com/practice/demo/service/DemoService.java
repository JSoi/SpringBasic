package com.practice.demo.service;

import com.practice.demo.dto.PublicApiRequestDto;
import com.practice.demo.dto.PublicApiResponseDto;
import com.practice.demo.model.LocationKeywordSearchForm;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class DemoService {
    public static void main(String[] args) throws UnsupportedEncodingException {


    }

    public Mono<PublicApiResponseDto> giveMonoStore(PublicApiRequestDto publicApiRequestDto)throws UnsupportedEncodingException {
        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .responseTimeout(Duration.ofMillis(5000))
                .doOnConnected(conn ->
                        conn.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS))
                                .addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS)));
        WebClient client = WebClient.builder()
                .baseUrl("http://openapi.seoul.go.kr:8088")
//                .defaultCookie("cookieKey", "cookieValue")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE)
                .defaultUriVariables(Collections.singletonMap("url", "http://openapi.seoul.go.kr:8088"))
                .clientConnector(new ReactorClientHttpConnector(httpClient)) // 위의 타임아웃 적용
                .build();

        String key = URLEncoder.encode(publicApiRequestDto.getKey(), "UTF-8"); /*인증키 (sample사용시에는 호출시 제한됩니다.)*/
        String type = URLEncoder.encode(publicApiRequestDto.getType(), "UTF-8"); /*요청파일타입 (xml,xmlf,xls,json) */
        String service = URLEncoder.encode(publicApiRequestDto.getService(), "UTF-8"); /*서비스명 (대소문자 구분 필수입니다.)*/
        String start = URLEncoder.encode(String.valueOf(publicApiRequestDto.getStartIndex()), "UTF-8"); /*요청시작위치 (sample인증키 사용시 5이내 숫자)*/
        String end = URLEncoder.encode(String.valueOf(publicApiRequestDto.getEndIndex()), "UTF-8"); /*요청종료위치(sample인증키 사용시 5이상 숫자 선택 안 됨)*/

        return client.get().uri(
                        uriBuilder -> uriBuilder.pathSegment(key, type, service, start, end).path("/")
                                .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
//                .onStatus(HttpStatus::is4xxClientError, response -> {
//                    throw new IllegalAccessError("400");
//                })
//                .onStatus(HttpStatus::is5xxServerError, response -> {
//                    throw new IllegalAccessError("500");
//                })
                .bodyToMono(PublicApiResponseDto.class).log();
    }


    public Mono<LocationKeywordSearchForm> findRow(PublicApiResponseDto row) {
        reactor.netty.http.client.HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .responseTimeout(Duration.ofMillis(5000))
                .doOnConnected(conn ->
                        conn.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS))
                                .addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS)));
        WebClient client = WebClient.builder()
                .baseUrl("https://dapi.kakao.com/v2/local/search/keyword.json")
                .defaultUriVariables(Collections.singletonMap("url", "https://dapi.kakao.com/v2/local/search/keyword.json"))
                .clientConnector(new ReactorClientHttpConnector(httpClient)) // 위의 타임아웃 적용
                .build();
        return client.get().uri(uriBuilder
                        -> uriBuilder.queryParam("query",
                                "GG")
//                        .queryParam("category_group_code", "FD6") // 음식점으로 특정 - FD6
                        .queryParam("page", 1)
                        .queryParam("size", 1)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .header("Authorization", "KakaoAK 04940cceefec44d7adb62166b7971cd5")
                .retrieve().bodyToMono(LocationKeywordSearchForm.class);
    }

    public Mono<LocationKeywordSearchForm> finalResult(String storeName, LocationKeywordSearchForm.Documents documents) {

        reactor.netty.http.client.HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .responseTimeout(Duration.ofMillis(5000))
                .doOnConnected(conn ->
                        conn.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS))
                                .addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS)));
        WebClient client = WebClient.builder()
                .baseUrl("https://dapi.kakao.com/v2/local/search/keyword.json")
                .defaultUriVariables(Collections.singletonMap("url", "https://dapi.kakao.com/v2/local/search/keyword.json"))
                .clientConnector(new ReactorClientHttpConnector(httpClient)) // 위의타임아웃 적용
                .build();
        return client.get().uri(uriBuilder
                        -> uriBuilder.queryParam("query", storeName)
//                        .queryParam("category_group_code", "FD6") // 음식점으로 특정 - FD6
                        .queryParam("x", documents.getX())//위도, 경도 지정
                        .queryParam("y", documents.getY())
                        .queryParam("radius", 200)
                        .queryParam("page", 1)
                        .queryParam("size", 1)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .header("Authorization", "KakaoAK 04940cceefec44d7adb62166b7971cd5")
                .retrieve().bodyToMono(LocationKeywordSearchForm.class);
    }
}
