package com.tianyl.dubboDemo.provider.util;

public class ThreadUtil {

	public static void safeSleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
