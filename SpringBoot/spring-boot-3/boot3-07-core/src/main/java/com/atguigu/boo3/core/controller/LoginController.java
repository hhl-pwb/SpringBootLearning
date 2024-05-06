package com.atguigu.boo3.core.controller;

import com.atguigu.boo3.core.service.AccountService;
import com.atguigu.boo3.core.service.CouponSeeervice;
import com.atguigu.boo3.core.service.SysSrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class LoginController {
    @Autowired
    AccountService accountService;
    @Autowired
    CouponSeeervice couponSeeervice;
    @Autowired
    SysSrvice sysSrvice;
    @GetMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("passwd") String passwd){
        //业务处理逻辑
        System.out.println("业务处理登录完成........");
        //1、账户服务自动签到领取积分
        accountService.addAccountScore(username);
        //2、优惠服务随机发放优惠券
        couponSeeervice.sendCoupon(username);
        //3、系统服务登记用户登录信息
        sysSrvice.recodLog(username);

        //TODO 发布事件

        return username+"登录成功";
    }
}
