package com.atguigu.boo3.core.service;

import org.springframework.stereotype.Service;

@Service
public class CouponSeeervice {
    public void sendCoupon(String username){
        System.out.println(username+"随机领取了一张优惠券");
    }
}
