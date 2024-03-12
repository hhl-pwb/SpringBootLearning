package com.atguigu.boot.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
//@ConfigurationProperties(prefix = "pig")
//@Component
public class Pig {
    private Long id;
    private String name;
    private Integer age;
}
