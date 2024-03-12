package com.atguigu.boot.config;

import com.alibaba.druid.FastsqlException;
import com.atguigu.boot.bean.Sheep;
import com.atguigu.boot.bean.User;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

//@Import(FastsqlException.class) //给容器中放入指定类型的组件，组将的名字默认是类名

/**
 * 1、开启Sheep组件的属性绑定
 * 2、默认会把这个组件自己放到容器中
 * @EnableConfigrationProperties主要用于导入第三方写好的组件进行属性绑定
 * SpringBoot默认只扫描自己主程序所在的包，如果导入第三方包,
 * 即使组件上标注了@Component、@ConfigrationProperties注解，也没用
 * 因为这些组将都扫描不进来
 */
@EnableConfigurationProperties(Sheep.class)
@SpringBootConfiguration //这是一个配置类，是springBoot中的配置类
//@Configuration //这是一个配置类，代替以前的xml配置文件。配置类本身也是容器中的组件
public class AppConfig {
    /**
     *组件默认是单实例的
     */
    @Scope("prototype") //设置组件是多实例
    @Bean("userHaha") // 替代xml配置文件中的Bean标签。
    // 组件在IOC容器中的名字默认是方法名，可以在@Bean标签中设置该组件在容器中的名字
    public User user(){
        var user = new User();
        user.setId(1);
        user.setName("张三");
        return user;
    }
    /**
     * 导入第三方包的两种方式
     * 1、使用@Bean方式
     */
//    @Bean
//    public FastsqlException fastsqlException(){
//        return new FastsqlException();
//    }
}
