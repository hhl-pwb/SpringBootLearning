package com.atguigu.boo3.core.service;

import org.springframework.stereotype.Service;

@Service
public class AccountService {
    public void addAccountScore(String username){
        System.out.println(username+"增加了1分");
    }
}
