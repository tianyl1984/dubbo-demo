package com.tianyl.dubboDemo.api;

import java.io.Serializable;

public interface CallbackListener extends Serializable {

	public String doCallBack(String name);

}
