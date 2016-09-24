package com.tianyl.dubboDemo.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;

@Configuration
@ImportResource("classpath:dubbo.xml")
public class DubboConf {

	// @Bean
	public ApplicationConfig appConfig() {
		ApplicationConfig config = new ApplicationConfig();
		config.setName("demo");
		return config;
	}

	// @Bean
	public RegistryConfig regConfig() {
		RegistryConfig config = new RegistryConfig();
		config.setCheck(false);
		config.setProtocol("multicast");
		return config;
	}

	// @Bean
	public ProtocolConfig proConfig() {
		ProtocolConfig config = new ProtocolConfig();
		config.setName("multicast");
		config.setPort(8111);
		return config;
	}

}
