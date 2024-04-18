package com.atguigu.boot3.feature.bean;

import lombok.Data;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Data
@Profile({"prod"})
@Component
public class Pig {
    private Long id;
    private String name;
}
