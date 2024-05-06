package com.atguigu.boo3.core.service;

import org.springframework.stereotype.Service;

@Service
public class SysSrvice {
    public void recodLog(String username){
        System.out.println(username+"系统获取了登录信息");
    }
}
