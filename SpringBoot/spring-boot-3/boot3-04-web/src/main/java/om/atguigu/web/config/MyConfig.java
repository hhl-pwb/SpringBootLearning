package om.atguigu.web.config;


import om.atguigu.web.component.MyYamlHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.concurrent.TimeUnit;
//@EnableWebMvc //禁用SpringBoot的默认配置
@Configuration //这是一个配置类
public class MyConfig /**implements WebMvcConfigurer**/ {
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        // 保留以前的默认配置，可以不用写，也是生效的。
//        WebMvcConfigurer.super.addResourceHandlers(registry);
//        // 自己写的信规则
//        registry.addResourceHandler("/static/**")
//                .addResourceLocations("classpath:/a/","classpath:/b/")
//                .setCacheControl(CacheControl.maxAge(1180, TimeUnit.SECONDS));
//    }
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override//配置静态资源
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                WebMvcConfigurer.super.addResourceHandlers(registry);
                //        // 自己写的信规则
                registry.addResourceHandler("/static/**")
                        .addResourceLocations("classpath:/a/", "classpath:/b/")
                        .setCacheControl(CacheControl.maxAge(1180, TimeUnit.SECONDS));
            }

            @Override //配置拦截器
            public void addInterceptors(InterceptorRegistry registry) {
                WebMvcConfigurer.super.addInterceptors(registry);
            }
            @Override
            public void configureMessageConverters(List<HttpMessageConverter<?>> converters){
                converters.add(new MyYamlHttpMessageConverter());
            }

        };
    }
}
