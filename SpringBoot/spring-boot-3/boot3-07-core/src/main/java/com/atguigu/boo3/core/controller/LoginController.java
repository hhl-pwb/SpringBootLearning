package com.atguigu.boo3.core.controller;

import com.atguigu.boo3.core.entity.UserEntity;
import com.atguigu.boo3.core.event.EventPublisher;
import com.atguigu.boo3.core.event.LoginSuccessEvent;
import com.atguigu.boo3.core.service.AccountService;
import com.atguigu.boo3.core.service.CouponSeeervice;
import com.atguigu.boo3.core.service.SysSrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
//    @Autowired
//    AccountService accountService;
//    @Autowired
//    CouponSeeervice couponSeeervice;
//    @Autowired
//    SysSrvice sysSrvice;

    @Autowired
    EventPublisher eventPublisher;
    @GetMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("passwd") String passwd){
//        //1、账户服务自动签到领取积分
//        accountService.addAccountScore(username);
//        //2、优惠服务随机发放优惠券
//        couponSeeervice.sendCoupon(username);
//        //3、系统服务登记用户登录信息
//        sysSrvice.recodLog(username);
        //业务处理逻辑
        System.out.println("业务处理登录完成........");
        // TODO 发布事件
        // 1、创建事件信息
        LoginSuccessEvent event = new LoginSuccessEvent(new UserEntity(username, passwd));
        //2、发送事件
        eventPublisher.sendEvent(event);
        return username+"登录成功";
    }
}
