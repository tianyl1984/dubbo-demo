package com.tianyl.dubboDemo.provider.conf;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.tianyl.dubboDemo.api.ITimeService;
import com.tianyl.dubboDemo.provider.service.TimeService;

@Configuration
public class DubboBeanPostProcessor implements BeanPostProcessor, ApplicationContextAware {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// System.out.println("postProcessAfterInitialization:" + beanName);
		if (bean.getClass().getName().startsWith(TimeService.class.getName())) {
			ServiceConfig<Object> service = new ServiceConfig<>();
			service.setApplication(applicationContext.getBean(ApplicationConfig.class));
			service.setInterface(ITimeService.class);
			service.setRegistry(applicationContext.getBean(RegistryConfig.class));
			service.setRef(bean);
			service.export();
		}
		return bean;
	}

	@Bean
	public ApplicationConfig appConfig() {
		ApplicationConfig config = new ApplicationConfig();
		config.setName("demo");
		return config;
	}

	@Bean
	public RegistryConfig regConfig() {
		RegistryConfig config = new RegistryConfig();
		config.setAddress("zookeeper://192.168.0.104:2181");
		return config;
	}

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

}
