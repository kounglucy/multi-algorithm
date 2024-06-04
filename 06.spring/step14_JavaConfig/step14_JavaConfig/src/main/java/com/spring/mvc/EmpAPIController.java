package com.spring.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.Dept;
import com.spring.dto.Emp;
import com.spring.service.DeptService;
import com.spring.service.EmpService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class EmpAPIController {
	
	final EmpService empService;
	
	// http://localhost:8082/api/emp/{empno}
	@RequestMapping(value = "/api/emp/{empno}",
					method = RequestMethod.GET)
	public Emp getAPIEmpByDeptno(@PathVariable int empno) throws Exception {
		System.out.println("getAPIEmpByDeptno()");
		Emp emp = empService.getEmpByDeptno(empno);
	
		return emp;
	}
	
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<String> handleException(Exception e){
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
