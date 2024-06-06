package com.atguigu.boot3.rpc.service;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import reactor.core.publisher.Mono;

public interface WeatherInterface {
    @GetExchange(url = "https://restapi.amap.com/v3/weather/weatherInfo", accept = "application/json")
    Mono<String> getWeather(@RequestParam("city") String city,
                            @RequestParam("key") String key);
}
