package com.spring.mvc;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	// 예외 step02 : LoginController 내부에서 발행하는 모든 NPE 처리
	@ExceptionHandler({Exception.class})
	public ModelAndView nullPointerExceptionHandler(Exception exception) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("exception", exception);
		mv.setViewName("error");
		return mv;
	}
}
