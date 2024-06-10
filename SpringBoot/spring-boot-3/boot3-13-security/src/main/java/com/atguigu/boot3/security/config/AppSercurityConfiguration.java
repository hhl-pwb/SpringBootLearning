package com.atguigu.boot3.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 1、自定义授权规则：http.authorizeHttpRequests
 * 2、自定义登录规则：http.formLogin
 * 3、自定义用户信息的查询规则：UserDetailsService
 * 4、开启方法级别的精确权限控制：@EnableMethodSecurity
 */
@EnableMethodSecurity
@Configuration
public class AppSercurityConfiguration {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        //请求授权
        http.authorizeHttpRequests(registry -> {
            registry.requestMatchers("/").permitAll()//首页所有人都允许访问
                    .anyRequest().authenticated();//2、剩下的任意请求都需要 认证=登录
        });
        //表单登录
        //3、表单登录功能：开启默认表单登录功能，spring Security提供的默认登录页
        http.formLogin(formLogin -> {
            formLogin.loginPage("/login").permitAll();//自定义登录页位置，并且所有人都可以访问
        });
        return http.build();
    }

    // 查询用户详情
    @Bean
    UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails zhangsan = User.withUsername("zhangsan")
                .password(passwordEncoder.encode("123456"))
                .roles("admin", "hr")
                .authorities("file_read", "file_write")
                .build();
        UserDetails lisi = User.withUsername("lisi")
                .password(passwordEncoder.encode("123456"))
                .roles( "hr")
                .authorities("file_read")
                .build();
        UserDetails wangwu = User.withUsername("wangwu")
                .password(passwordEncoder.encode("123456"))
                .roles("hr")
                .authorities( "file_write")
                .build();
        //模拟内存中保存所有用户信息
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager(zhangsan,lisi,wangwu);

        return null;
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
