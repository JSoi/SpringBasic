package com.practice.demo.controller;

import com.practice.demo.dto.PublicApiRequestDto;
import com.practice.demo.dto.PublicApiResponseDto;
import com.practice.demo.model.Store;
import com.practice.demo.service.DemoService;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

@RestController
@RequiredArgsConstructor
public class DemoController {
    private final DemoService demoService;

    @PostMapping("/store")
    public Mono<PublicApiResponseDto> findAll(@RequestBody PublicApiRequestDto publicApiRequestDto) throws UnsupportedEncodingException {
        return demoService.giveMonoStore(publicApiRequestDto);
    }
}
