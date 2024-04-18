package com.atguigu.boot3.feature.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${haha:222222}")
    String haha;

    @GetMapping("/haha")
    public String haha() {
        return haha;
    }
}
