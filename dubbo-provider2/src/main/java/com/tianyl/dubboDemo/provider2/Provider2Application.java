package com.tianyl.dubboDemo.provider2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Provider2Application {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(Provider2Application.class, args);
		System.out.println("provider2 start");
		System.in.read();
	}

}
