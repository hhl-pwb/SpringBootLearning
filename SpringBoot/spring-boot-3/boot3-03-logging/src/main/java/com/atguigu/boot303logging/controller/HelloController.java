package com.atguigu.boot303logging.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class HelloController {
    @GetMapping("/h")
    public String hello(String a,String b){
        log.trace("trace 日志....");
        log.debug("debug 日志....");
        //SpringBoot底层默认的日志级别是info
        log.info("info 日志....参数a:{} b:{}",a,b);
        log.warn("warn 日志....");
        log.error("error 日志....");
        return "hello";
    }
}
