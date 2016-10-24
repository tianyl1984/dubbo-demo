package com.tianyl.dubboDemo.provider.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

	@Autowired
	private TimeService timeService;

	public void m1() {
		System.out.println("m1 execute");
		timeService.time();
	}

}
