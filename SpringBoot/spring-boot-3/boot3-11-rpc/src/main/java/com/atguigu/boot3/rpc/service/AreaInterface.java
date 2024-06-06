package com.atguigu.boot3.rpc.service;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import reactor.core.publisher.Mono;

public interface AreaInterface {
    @GetExchange(url = "https://restapi.amap.com/v3/config/district",accept = "application/json")
    Mono<String> getArea(@RequestParam("keywords") String keywords,
                         @RequestParam("subdistrict") String subdistrict,
                         @RequestParam("key") String key);
}
