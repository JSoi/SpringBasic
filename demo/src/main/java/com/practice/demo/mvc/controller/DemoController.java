package com.practice.demo.mvc.controller;

import com.practice.demo.mvc.dto.PublicApiRequestDto;
import com.practice.demo.mvc.dto.PublicApiResponseDto;
import com.practice.demo.mvc.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.io.UnsupportedEncodingException;

@RestController
@RequiredArgsConstructor
public class DemoController {
    private final DemoService demoService;

    @PostMapping("/store")
    public Mono<PublicApiResponseDto> findAll(@RequestBody PublicApiRequestDto publicApiRequestDto) throws UnsupportedEncodingException {
        return demoService.giveMonoStore(publicApiRequestDto);
    }
    
    @GetMapping("/userBuilder")
    public Mono<String> getBuilder(UriComponentsBuilder builder){
        return Mono.just(builder.buildAndExpand("").toUriString());
        
    }
}
