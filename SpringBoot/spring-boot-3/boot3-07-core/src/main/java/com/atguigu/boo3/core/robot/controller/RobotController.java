package com.atguigu.boo3.core.robot.controller;

import com.atguigu.boo3.core.robot.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RobotController {
    @Autowired
    RobotService robotService;

    @GetMapping("/robot/hello")
    public String sayHello() {
        return robotService.sayHello();
    }
}
