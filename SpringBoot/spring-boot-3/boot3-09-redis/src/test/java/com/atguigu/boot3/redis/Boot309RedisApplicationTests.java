package com.atguigu.boot3.redis;

import ch.qos.logback.classic.spi.EventArgUtil;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.UUID;

@SpringBootTest
class Boot309RedisApplicationTests {
    @Autowired
    StringRedisTemplate redisTemplate;

    /**
     * string ： 普通字符串   redisTemplate.opsForValue()
     */
    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("haha", UUID.randomUUID().toString());
        String haha = redisTemplate.opsForValue().get("haha");
        System.out.println(haha);
    }
    /**
     * list: 列表             redisTemplate.opsForList()
     */
    @Test
    void testList(){
        String listName = "listtest";
        redisTemplate.opsForList().leftPush(listName,"1");
        redisTemplate.opsForList().leftPush(listName,"2");
        redisTemplate.opsForList().leftPush(listName,"3");
        String pop = redisTemplate.opsForList().leftPop(listName);
        Assertions.assertEquals("3",pop);
    }
    /**
     * set: 集合              redisTemplate.opsForSet()
     */
    @Test
    void testSet(){
        String setName = "settest";
        redisTemplate.opsForSet().add(setName,"1","2","3","3");
        Boolean aBoolean = redisTemplate.opsForSet().isMember(setName, "3");
        Assertions.assertTrue(aBoolean);
        Boolean member = redisTemplate.opsForSet().isMember(setName, "5");
        Assertions.assertFalse(member);
    }
    /**
     * zset: 有序集合         redisTemplate.opsForZSet()
     */
    @Test
    void testZset(){
        String setName = "zsettest";
        redisTemplate.opsForZSet().add(setName,"张三",99);
        redisTemplate.opsForZSet().add(setName,"李四",10);
        redisTemplate.opsForZSet().add(setName,"王五",90);
        redisTemplate.opsForZSet().add(setName,"赵钱",99);
        redisTemplate.opsForZSet().add(setName,"孙里",-1);
        ZSetOperations.TypedTuple<String> popMax = redisTemplate.opsForZSet().popMax(setName);
        String value = popMax.getValue();
        Double score = popMax.getScore();
        System.out.println(value+"==>"+score);
    }
    /**
     * hash : k：v            redisTemplate.opsForHash()
     */
    @Test
    void testhash(){
        String mapName = "amap";
       redisTemplate.opsForHash().put(mapName,"name","张三");
        redisTemplate.opsForHash().put(mapName,"age","18");
        System.out.println(redisTemplate.opsForHash().get(mapName, "name"));
    }

}
