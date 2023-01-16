package com.practice.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chart")
@RequiredArgsConstructor
public class DrawChartController {
    private final ChartService chartService;


    @GetMapping(value="/strategy/performance/{id}",
            produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody byte[] getStrategyPerformance(@PathVariable String id)
            throws Exception {
        return chartService.getStrategyPerformance(id);
    }
}
