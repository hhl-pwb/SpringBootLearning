package com.atguigu.boot3.security.controller;

import jdk.jfr.Percentage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "Hello!Spring security";
    }
    
    @GetMapping("/world")
    public String world(){
        return "Hello!Spring security";
    }
}
