package com.tianyl.dubboDemo.provider2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianyl.dubboDemo.api.ICallTimeService;
import com.tianyl.dubboDemo.api.ITimeService;
import com.tianyl.dubboDemo.provider2.conf.DubboService;

@Service
@DubboService
public class CallTimeService implements ICallTimeService {

	@Autowired
	private ITimeService timeService;

	@Override
	public String callTime() {
		System.out.println("in CallTimeService ");
		String result = timeService.time();
		System.out.println("获取时间：" + result);
		return result;
	}

}
