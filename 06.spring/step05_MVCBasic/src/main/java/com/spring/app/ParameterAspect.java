package com.spring.app;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ParameterAspect {
	
	@Around("execution(*com.spring.mvc.*.*(..))")
	public void parameterAspect(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		System.out.println("메소드명:" + signature.getName());
		
		System.out.println("파라미터");
		Object[] args = joinPoint.getArgs();
		for(Object arg : args) {
			int i = 0;
			System.out.println("파라미터"+ i + " : " + arg);
		}
	}
	
	

}
