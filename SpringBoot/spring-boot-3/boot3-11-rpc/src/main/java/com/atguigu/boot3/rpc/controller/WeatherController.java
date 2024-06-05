package com.atguigu.boot3.rpc.controller;

import com.atguigu.boot3.rpc.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
public class WeatherController {
    @Autowired
    WeatherService weatherService;
    @GetMapping("/weather")
    public Mono<String> weather(@RequestParam("city") String city){
        Mono<String> weather = weatherService.weather(city);
        return weather;
    }
}
