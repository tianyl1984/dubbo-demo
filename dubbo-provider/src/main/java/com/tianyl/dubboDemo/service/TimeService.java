package com.tianyl.dubboDemo.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.tianyl.dubboDemo.api.ITimeService;

@Service
public class TimeService implements ITimeService {

	@Override
	public String time() {
		System.out.println("client get time");
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

}
