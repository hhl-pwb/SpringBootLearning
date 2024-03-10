package com.atguigu.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 启动SpringBoot项目的主入口程序
 */
@SpringBootApplication //这是一个SpringBoot应用
public class MainApplication {
    public static void main(String[] args) {
        // java10：局部变量类型的自动推断，只能用在局部变量
        var ioc = SpringApplication.run(MainApplication.class, args);
        // 获取容器中所有组件的名字
        String[] names = ioc.getBeanDefinitionNames();
        // 2、遍历 :dispatcherServlet、beanNameViewResolver（用于视图解析）、
        // characterEncodingFilter（字符编码）、multipartResolver（文件上传）
        // SpringBoot把以前配置的核心组件现在都给我们配置好了
        for (String name : names) {
            System.out.println(name);
        }
    }
}
