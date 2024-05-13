package com.atguigu.boot3.starter.robot.annotation;

import com.atguigu.boot3.starter.robot.RobotConfiguration;
import org.springframework.context.annotation.Import;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({RobotConfiguration.class})
public @interface EnableRobot {
}
