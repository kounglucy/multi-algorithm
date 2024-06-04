package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.Dept;

@RestController
public class HomeAPIController {
	
	@Autowired
	Dept dept;
	
	@Value("${props.name}")
	private String propsName; 
	
	@RequestMapping(value = "/api/home")
	public String home() {
		System.out.println("home test");
		System.out.println("propsName : " + propsName);
		
		/*
		 	- Dept 객체가 loc = ${props.name} 값을 초기값으로 갖고 있도록 지정하기 위해
		 	@Autowired로 Dept를 주입
		 		@Autowired
				Dept dept;
		 	
		 	
		 	- 해당 결과 
		 		dept(@bean) : Dept(deptno=0, dname=null, loc=dev)
				dept(not bean) : Dept(deptno=0, dname=null, loc=null)
			
			*** @Value를 사용하기 위해서는 @Bean으로 등록한 객체만이 사용 가능
		 */
		System.out.println("---");
		System.out.println("dept(@bean) : " + dept.toString());
		System.out.println("dept(not bean) : " + new Dept().toString());
		
		return "home";
	}
	
}
