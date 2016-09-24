package com.tianyl.dubboDemo.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProviderApplication {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(ProviderApplication.class, args);
		System.out.println("provider start");
		// context.getBean(ITimeService.class).time();
		// System.out.println("---------------");
		// context.getBean(TimeService.class).time();
		// System.out.println("---------------");
		// context.getBean(DemoService.class).m1();
		System.in.read();
	}

}
