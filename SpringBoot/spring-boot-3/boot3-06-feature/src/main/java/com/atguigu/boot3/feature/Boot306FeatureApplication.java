package com.atguigu.boot3.feature;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

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
		new SpringApplicationBuilder()
				.main(Boot306FeatureApplication.class)
				.sources(Boot306FeatureApplication.class)
				.bannerMode(Banner.Mode.CONSOLE)
				.run(args);
	}
}
