package com.atguigu.boot3.feature.bean;

import lombok.Data;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Data
@Profile({"default"})
@Component
public class Sheep {
    private Long id;
    private String name;
}
