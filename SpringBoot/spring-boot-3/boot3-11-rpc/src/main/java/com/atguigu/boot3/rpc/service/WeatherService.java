package com.atguigu.boot3.rpc.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherService {
    public Mono<String> weather(String city) {
        //远程调用高德
        WebClient client = WebClient.create();
        // 1 创建WebClient
        Map<String, String> params = new HashMap<>();
        // 2 准备数据
        params.put("city",city);
        // 3 定义发请求行为
        Mono<String> mono = client.get()
                .uri("https://restapi.amap.com/v3/weather/weatherInfo?key=b914a7c166feead5ec08d3a73b3a3693&city={city}", params)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class);
        return mono;
    }
}
