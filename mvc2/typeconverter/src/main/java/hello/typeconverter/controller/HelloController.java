package hello.typeconverter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
@Slf4j
public class HelloController {
    @GetMapping("/hello-v1")
    public String helloV1(HttpServletRequest request) { // 직접 받아보자
        String data = request.getParameter("data"); // String으로 받아서
        Integer intValue = Integer.valueOf(data); // Integer로 타입변경
        log.info("intValue = {}", intValue);
        return "ok";
    }

    @GetMapping("/hello-v2")
    public String helloV2(@RequestParam Integer data) { // 스프링이 문자 타입을 숫자 타입으로 변환
        System.out.println("data = " + data);
        return "ok";
    }
}
