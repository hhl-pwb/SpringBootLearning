package com.atguigu.boot3.ssm.controller;

import com.atguigu.boot3.ssm.bean.Tuser;
import com.atguigu.boot3.ssm.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user/{id}")
    public Tuser getUserById(@PathVariable("id")  Long id){
        Tuser tuser = userMapper.getUserById(id);
        return tuser;
    }
}
