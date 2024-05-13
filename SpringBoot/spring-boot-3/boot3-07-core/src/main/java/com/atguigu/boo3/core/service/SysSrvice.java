package com.atguigu.boo3.core.service;

import com.atguigu.boo3.core.entity.UserEntity;
import com.atguigu.boo3.core.event.LoginSuccessEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class SysSrvice {
    @EventListener
    public void onEvent(LoginSuccessEvent event){
        System.out.println("=====SysSrvice收到事件========");
        UserEntity source = (UserEntity) event.getSource();
        recodLog(source.getUsername());
    }
    public void recodLog(String username){
        System.out.println(username+"系统获取了登录信息");
    }
}
