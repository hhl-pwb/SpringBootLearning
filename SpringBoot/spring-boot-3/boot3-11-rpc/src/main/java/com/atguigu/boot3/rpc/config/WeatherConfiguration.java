package com.atguigu.boot3.rpc.config;

import com.atguigu.boot3.rpc.service.WeatherService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WeatherConfiguration {
    HttpServiceProxyFactory factory(){
        //1 创建客户端
        WebClient client = WebClient.builder()
                .codecs(clientCodecConfigurer -> {
                    clientCodecConfigurer
                            .defaultCodecs()
                            .maxInMemorySize(256*1024*1024);
                    //响应数据量太大可能会超出BufferSize，所以这里设置的大一点
                }).build();
        // 创建工厂
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(client)).build();
        return factory;
    }
}
