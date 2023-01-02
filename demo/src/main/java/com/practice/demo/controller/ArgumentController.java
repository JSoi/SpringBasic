package com.practice.demo.controller;

import com.practice.demo.annotation.Arg;
import com.practice.demo.dto.ArgDto;
import com.practice.demo.entity.ArgEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/argument")
@RestController
public class ArgumentController {
    @PostMapping("/test")
    public ResponseEntity<?> getTest(@Arg ArgDto arg) {
        System.out.println("arg = " + arg);
        System.out.println("arg.getClass() = " + arg.getClass());
        return ResponseEntity.ok(arg);
    }
}
