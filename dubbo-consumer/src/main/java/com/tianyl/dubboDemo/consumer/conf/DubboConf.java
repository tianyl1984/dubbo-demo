package com.tianyl.dubboDemo.consumer.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;

@Configuration
@ImportResource("classpath:dubbo.xml")
public class DubboConf {

	// @Bean
	public ApplicationConfig getApplicationConfig() {
		ApplicationConfig application = new ApplicationConfig();
		application.setName("demo");
		application.setVersion("1.0");
		return application;
	}

	// 服务提供者协议配置
	// @Bean(name = "dubboProtocol")
	public ProtocolConfig getProtocolConfig() {
		ProtocolConfig protocol = new ProtocolConfig();
		protocol.setName("dubbo");
		return protocol;
	}

	// 连接注册中心配置
	// @Bean(name = "defaultRegistry")
	public RegistryConfig getRegistryConfig() {
		RegistryConfig registry = new RegistryConfig();
		registry.setAddress("zookeeper://172.16.53.244:2181");
		return registry;
	}

}
