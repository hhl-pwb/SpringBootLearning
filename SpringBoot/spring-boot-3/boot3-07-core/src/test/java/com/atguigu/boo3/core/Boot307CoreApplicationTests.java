package com.atguigu.boo3.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class Boot307CoreApplicationTests {

    @Test
    void contextLoads() {
        User user = new User(11,"xm");
        String xm = Optional.ofNullable(user)
                .filter(us -> "xm".equals(us.getName()))
                .map(User::getName)
                .orElseGet(() -> {
                    User user1 = new User();
                    user1.setName("11111111");
                    return user1.getName();
                });
        System.out.println(xm);

    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class User{
        private Integer age;
        private String name;
    }
}
