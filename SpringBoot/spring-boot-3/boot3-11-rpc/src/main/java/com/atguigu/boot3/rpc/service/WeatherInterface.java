package com.atguigu.boot3.rpc.service;

import org.springframework.web.service.annotation.GetExchange;

public interface WeatherInterface {
    @GetExchange(url = "https://restapi.amap.com/v3/geocode/regeo?parameters")
}
