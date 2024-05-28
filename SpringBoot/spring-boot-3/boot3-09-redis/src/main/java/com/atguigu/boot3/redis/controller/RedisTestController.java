package com.atguigu.boot3.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisTestController {
    @Autowired
    StringRedisTemplate redisTemplate;
    @GetMapping("/count")
    public String count(){
        Long hello = redisTemplate.opsForValue().increment("hello");
        /**
         * redis常见数据类型 k:v value可以有很多中类型
         * string ： 普通字符串   redisTemplate.opsForValue()
         * list: 列表             redisTemplate.opsForList()
         * set: 集合              redisTemplate.opsForSet()
         * zset: 有序集合         redisTemplate.opsForZSet()
         * hash : k：v            redisTemplate.opsForHash()
         */

        return "访问了【"+hello+"】次";
    }
}
