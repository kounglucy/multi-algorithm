package com.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Component
public class TestInterceptor2 implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			                 HttpServletResponse response, 
			                 Object handler) throws Exception {
		
		log.info("preHandle");
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, 
			               HttpServletResponse response, 
			               Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
		
		log.info("postHandle");
			
		}

	@Override
	public void afterCompletion(HttpServletRequest request, 
								HttpServletResponse response, 
								Object handler,
								@Nullable Exception ex) throws Exception {
		
		log.info("afterCompletion");
			
		}

	
}