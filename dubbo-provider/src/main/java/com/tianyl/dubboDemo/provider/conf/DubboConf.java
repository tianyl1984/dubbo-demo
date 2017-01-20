package com.tianyl.dubboDemo.provider.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.util.StringUtils;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.MonitorConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;

@Configuration
@ImportResource("classpath:dubbo.xml")
public class DubboConf {

	@Value("${dubbo.application.name}")
	private String applicationName;

	@Value("${dubbo.application.version}")
	private String applicationVersion;

	@Value("${dubbo.application.owner}")
	private String applicationOwner;

	@Value("${dubbo.application.organization}")
	private String applicationOrganization;

	@Value("${dubbo.registry.address}")
	private String registryAddress;

	@Value("${dubbo.registry.group}")
	private String registryGroup;

	@Value("${dubbo.protocol.dubbo.port}")
	private int port;

	@Value("${dubbo.protocol.dubbo.host}")
	private String host;

	@Value("${dubbo.protocol.dubbo.threads}")
	private int threads;

	@Bean
	public ApplicationConfig getApplicationConfig() {
		ApplicationConfig application = new ApplicationConfig();
		application.setName(applicationName);
		application.setVersion(applicationVersion);
		application.setOwner(applicationOwner);
		application.setOrganization(applicationOrganization);
		return application;
	}

	// 服务提供者协议配置
	@Bean(name = "dubboProtocol")
	public ProtocolConfig getProtocolConfig() {
		ProtocolConfig protocol = new ProtocolConfig();
		protocol.setName("dubbo");
		protocol.setPort(port);
		if (!StringUtils.isEmpty(host)) {
			protocol.setHost(host);
		}
		protocol.setThreads(threads);
		return protocol;
	}

	// 连接注册中心配置
	@Bean(name = "defaultRegistry")
	public RegistryConfig getRegistryConfig() {
		RegistryConfig registry = new RegistryConfig();
		registry.setAddress(this.registryAddress);
		// registry.setSession(30000);
		// registry.setCheck(true);
		if (!StringUtils.isEmpty(registryGroup)) {
			registry.setGroup(registryGroup);
		}
		return registry;
	}

	// 监控
	@Bean
	public MonitorConfig getMonitor() {
		MonitorConfig config = new MonitorConfig();
		config.setProtocol("registry");
		return config;
	}
}
