package com.atguigu.boot3.rpc.controller;

import com.atguigu.boot3.rpc.service.AreaInterface;
import com.atguigu.boot3.rpc.service.WeatherInterface;
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
    @Autowired
    WeatherInterface weatherInterface;
    @Autowired
    AreaInterface areaInterface;

    @GetMapping("/weather")
    public Mono<String> weather(@RequestParam(value = "city", required = false) String city) {
//        Mono<String> weather = weatherService.weather(city);
        Mono<String> weather = weatherInterface.getWeather("110101",
                "b914a7c166feead5ec08d3a73b3a3693");
        return weather;
    }

    @GetMapping("/area")
    public Mono<String> area(@RequestParam(value = "keywords", required = false) String keywords,
                             @RequestParam(value = "subdistrict", required = false) String subdistrict) {
        Mono<String> areaInterfaceArea = areaInterface.getArea(keywords, subdistrict
                , "557d514d0f256d2e8b7bbc0a2098e4c1");
        return areaInterfaceArea;
    }


}
