package com.tianyl.dubboDemo.provider.service;

import org.springframework.stereotype.Service;

import com.tianyl.dubboDemo.api.CallbackListener;
import com.tianyl.dubboDemo.api.ICallbackDemoService;
import com.tianyl.dubboDemo.provider.conf.DubboService;

@Service
@DubboService
public class CallbackDemoService implements ICallbackDemoService {

	@Override
	public String call(String name, CallbackListener listener) {
		System.out.println("execute call");
		listener.doCallBack(name);
		return "hello " + name;
	}

}
