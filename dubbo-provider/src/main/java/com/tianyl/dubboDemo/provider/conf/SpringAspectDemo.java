package com.tianyl.dubboDemo.provider.conf;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SpringAspectDemo {

	@Around("execution(* com.tianyl.dubboDemo.provider.service.*.*(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("before execute");
		Object obj = joinPoint.proceed();
		System.out.println("after execute");
		return obj;
	}

}
