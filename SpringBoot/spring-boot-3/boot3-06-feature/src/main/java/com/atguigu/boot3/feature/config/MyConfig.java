package com.atguigu.boot3.feature.config;

import com.atguigu.boot3.feature.bean.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//@Profile({"test"}) //只有指定环境被激活，这个类的所有配置才能生效
//@Configuration
public class MyConfig {
//    @Profile({"dev"}) //单独设置也可以，但是如果在配置类上的@Profile标识的环境不生效，此处也不会生效
//    @Bean
//    public Cat cat(){
//        return new Cat();
//    }
}
