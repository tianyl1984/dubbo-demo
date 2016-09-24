package com.tianyl.dubboDemo.consumer.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:dubbo.xml")
public class DubboConf {

}
