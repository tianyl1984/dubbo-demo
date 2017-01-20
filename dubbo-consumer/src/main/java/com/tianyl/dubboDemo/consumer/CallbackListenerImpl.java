package com.tianyl.dubboDemo.consumer;

import com.tianyl.dubboDemo.api.CallbackListener;

public class CallbackListenerImpl implements CallbackListener {

	private static final long serialVersionUID = 5322859122403415729L;

	@Override
	public String doCallBack(String name) {
		System.out.println("client call back:" + name);
		return name;
	}

}
