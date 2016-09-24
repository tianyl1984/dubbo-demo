package com.tianyl.dubboDemo.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.tianyl.dubboDemo.api.ITimeService;

@SpringBootApplication
public class ConsumerApplication {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(ConsumerApplication.class, args);
		System.out.println("start");
		ITimeService timeService = context.getBean(ITimeService.class);
		System.out.println("获取服务器时间：" + timeService.time());
	}

}
