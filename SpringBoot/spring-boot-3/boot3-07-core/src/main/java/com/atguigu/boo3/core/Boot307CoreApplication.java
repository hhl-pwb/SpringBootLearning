package com.atguigu.boo3.core;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Boot307CoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(Boot307CoreApplication.class, args);
    }
    @Bean
    public ApplicationRunner applicationRunner(){
        return args -> System.out.println("=======applicationRunner运行了========");
    }
    @Bean
    public CommandLineRunner commandLineRunner(){
        return args -> System.out.println("=======commandLineRunner运行了=====");
    }

}
