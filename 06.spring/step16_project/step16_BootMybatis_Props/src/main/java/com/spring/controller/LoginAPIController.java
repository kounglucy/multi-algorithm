package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.spring.dto.Emp;
import com.spring.service.EmpService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class LoginAPIController {

	
	
	@Autowired 
	final EmpService service;
	
	@RequestMapping(value = "/api/emp/{empno}",
			method = RequestMethod.GET)
	public Emp getAPIEmpByEmpno(@PathVariable int empno) throws Exception {
		Emp emp = service.getAPIEmpByEmpno(empno);
		
		
		return emp;
		
	}
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<String> handleException(Exception e){
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
