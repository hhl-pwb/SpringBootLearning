package com.atguigu.boo3.core.service;

import com.atguigu.boo3.core.entity.UserEntity;
import com.atguigu.boo3.core.event.LoginSuccessEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class CouponSeeervice {
    @EventListener
    public void onEvent(LoginSuccessEvent event){
        System.out.println("========CouponSeeervice 收到事件=====");
        UserEntity source = (UserEntity) event.getSource();
        sendCoupon(source.getUsername());

    }
    public void sendCoupon(String username){
        System.out.println(username+"随机领取了一张优惠券");
    }
}
