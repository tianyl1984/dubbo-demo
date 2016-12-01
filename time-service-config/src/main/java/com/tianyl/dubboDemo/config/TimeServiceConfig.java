package com.tianyl.dubboDemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.tianyl.dubboDemo.api.ITimeService;

@Configuration
public class TimeServiceConfig {

	@Autowired
	private ApplicationConfig application;

	@Autowired
	private RegistryConfig registry;

	@Bean
	public ITimeService getTimeService() {
		ReferenceConfig<ITimeService> reference = new ReferenceConfig<ITimeService>();
		reference.setApplication(application);
		reference.setRegistry(registry);
		reference.setInterface(ITimeService.class);
		reference.setVersion("1.0");
		reference.setTimeout(3000);
		reference.setRetries(0);
		reference.setCheck(false);
		return reference.get();
	}
}
