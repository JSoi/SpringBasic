package com.practice.demo.mvc.controller;

import com.practice.demo.mvc.annotation.Arg;
import com.practice.demo.mvc.dto.ArgDto;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/argument")
@RestController
@Slf4j
public class ArgumentController {
    @PostMapping("/test")
    public ResponseEntity<?> getTest(@Arg ArgDto arg) {
        System.out.println("arg = " + arg);
        System.out.println("arg.getClass() = " + arg.getClass());
        return ResponseEntity.ok(arg);
    }
    
    @PostMapping("/test2")
    public ResponseEntity<?> getTestV2(@Valid @RequestBody ArgDto argDto,
                                       BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            log.info("bindingResult = {}", bindingResult);
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(argDto);
    }
}
