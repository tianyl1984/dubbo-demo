package com.tianyl.dubboDemo.provider.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianyl.dubboDemo.api.ITimeService;
import com.tianyl.dubboDemo.provider.conf.DubboService;

@Service
@DubboService
public class TimeService implements ITimeService {

	@Autowired
	private DemoService demoService;

	@Override
	public String time() {
		System.out.println("client get time");
		// ThreadUtil.safeSleep(100 * 1000);
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

}
