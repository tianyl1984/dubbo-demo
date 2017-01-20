package com.tianyl.dubboDemo.provider.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.AnnotationUtils;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;

/**
 * 暴露dubbo服务
 * 
 * @author tianyale 2016年7月26日
 *
 */
// @Component
public class DubboServiceExportProcessor implements BeanPostProcessor, ApplicationContextAware {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ApplicationConfig application;

	@Autowired
	private ProtocolConfig protocol;

	@Autowired
	private RegistryConfig registry;

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		DubboService annotation = AnnotationUtils.findAnnotation(bean.getClass(), DubboService.class);
		if (annotation != null) {
			// 注意：ServiceConfig为重对象，内部封装了与注册中心的连接，以及开启服务端口
			// 服务提供者暴露服务配置
			ServiceConfig<Object> service = new ServiceConfig<>();
			// 此实例很重，封装了与注册中心的连接，请自行缓存，否则可能造成内存和连接泄漏
			service.setApplication(application);
			service.setRegistry(registry); // 多个注册中心可以用setRegistries()
			service.setProtocol(protocol); // 多个协议可以用setProtocols()
			Class<?> exportService = this.getServiceInterface(bean);
			service.setInterface(exportService);
			// 可能bean不是代理类，获取代理类
			service.setRef(applicationContext.getBean(bean.getClass()));
			service.setVersion(application.getVersion());
			// 暴露及注册服务
			service.export();
			logger.info("导出服务：{}", exportService);
		}
		return bean;
	}

	private Class<?> getServiceInterface(Object bean) {
		Class<?> clazz = AopUtils.getTargetClass(bean);
		Class<?>[] classes = clazz.getInterfaces();
		if (classes.length == 0) {
			throw new RuntimeException("dubbo服务必须实现一个接口");
		} else if (classes.length > 1) {
			throw new RuntimeException("dubbo服务只能实现一个接口");
		}
		return classes[0];
	}

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
