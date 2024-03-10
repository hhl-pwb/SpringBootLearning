package com.atguigu.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Boot302DemoApplication {

    public static void main(String[] args) {
        var ioc = SpringApplication.run(Boot302DemoApplication.class, args);
        for(String name:ioc.getBeanDefinitionNames()){
            System.out.println(name);
        }

        Object userHaha1 = ioc.getBean("userHaha");
        Object userHaha2 = ioc.getBean("userHaha");
        System.out.println(userHaha1==userHaha2);
    }

}
