package com.tianyl.dubboDemo.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.tianyl.dubboDemo.api.ICallbackDemoService;

@SpringBootApplication
public class ConsumerApplication {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(ConsumerApplication.class, args);
		System.out.println("start");
		// ITimeService timeService = context.getBean(ITimeService.class);
		// System.out.println("获取服务器时间：" + timeService.time());
		// ICallTimeService timeService = context.getBean(ICallTimeService.class);
		// System.out.println("获取服务器时间：" + timeService.callTime());
		ICallbackDemoService callbackService = context.getBean(ICallbackDemoService.class);
		callbackService.call("张三", new CallbackListenerImpl());
		System.in.read();
	}

}
