package com.atguigu.boot3.feature;

import com.atguigu.boot3.feature.bean.Cat;
import com.atguigu.boot3.feature.bean.Dog;
import com.atguigu.boot3.feature.bean.Pig;
import com.atguigu.boot3.feature.bean.Sheep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 1、标识环境
 * 		1)、区分出几个环境：dev(开发环境) 、 test(测试环境) 、prod(生成环境)
 * 		2)、指定每个组件在哪个环境中生效；defout环境：默认环境
 * 			通过：@Profile({"test"})标注
 * 			组件没有标注@Profile代表任意时刻都生效
 * 		3)、默认只有激活指定的环境，这些组件才会生效
 * 2、激活环境
 * 		1)、配置文件激活：spring.profiles.active=dev
 * 		2)、命令行激活： java -jar xxx.jar --spring.profiles.active=dev
 * 3、配置文件怎么使用Profile功能
 * 		1)、application.properties:主配置文件，任何情况下都生效
 * 		2)、其他Profile环境下命名规则：application-{profile标识}.properties:
 * 				比如：application-dev.properties
 * 		3)、激活指定环境方式：配置文件激活、命名行方式激活
 * 		4)、效果：
 * 			项目的所有生效配置项 = 激活环境配置文件的所有项 + 主配置文件和激活配置文件不冲突的所有项
 * 			如果发生了配置冲突，以激活的环境配置文件为准
 * 			application-{profile标识}.properties优先级 大于 application.properties优先级
 *
 * 			主配置和激活配置都生效，优先以激活的配置为准
 */
@Slf4j
@SpringBootApplication //主程序类
public class Boot306FeatureApplication {
	public static void main(String[] args) {
		// 1、SpringApplication:是springBoot应用的核心API入口
//		SpringApplication.run(Boot306FeatureApplication.class, args);
		// 1、自定义SpringApplication的底层设置
//		SpringApplication springApplication = new SpringApplication(Boot306FeatureApplication.class);
		// 程序化调整【SpringApplication的参数】,例如此显示banner
		// 【application.properties配置的文件的优先级高于程序化调整的优先级】
//		springApplication.setBannerMode(Banner.Mode.CONSOLE);
		// 2、SpringApplication运行起来
//		springApplication.run(args);
		//Buider方式构建SpringApplication;通过FlentAPI设置
		ConfigurableApplicationContext context = new SpringApplicationBuilder()
				.main(Boot306FeatureApplication.class)
				.sources(Boot306FeatureApplication.class)
				.bannerMode(Banner.Mode.CONSOLE)
				.run(args);
		try {
			Cat cat = context.getBean(Cat.class);
			log.info("组件cat: {}",cat);
		}catch (Exception e){}
		try {
			Dog dog = context.getBean(Dog.class);
			log.info("组件dog: {}",dog);
		}catch (Exception e){}
		try {
			Pig pig = context.getBean(Pig.class);
			log.info("组件pig: {}",pig);
		}catch (Exception e){}
		try {
			Sheep sheep = context.getBean(Sheep.class);
			log.info("组件sheep: {}",sheep);
		}catch (Exception e){}








	}
}
