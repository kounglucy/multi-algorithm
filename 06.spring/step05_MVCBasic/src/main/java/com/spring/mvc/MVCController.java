package com.spring.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dto.Student;

@Controller
public class MVCController {
	
	// http://localhost:8082/mvc/test1
	@RequestMapping(value = "/test1",method = RequestMethod.GET)
	public void test1() {
		System.out.println("MVCController : test1");
	}
	
	// http://localhost:8082/mvc/test2?id=dev
	@RequestMapping(value = "/test2",method = RequestMethod.GET)
	public void test2(HttpServletRequest request) {
		System.out.println("MVCController : test2");
		System.out.println("id : " + request.getParameter("id"));
	}
	
	// http://localhost:8082/mvc/test3?id=dev
	@RequestMapping(value = "/test3",method = RequestMethod.GET)
	public void test3(@RequestParam("asdf") String id) {
		System.out.println("MVCController : test3");
		System.out.println("id : " + id);
	}
	
	// http://localhost:8082/mvc/test4?id=dev&age=28
	@RequestMapping(value = "/test4", method = RequestMethod.GET)
	public void test4(@RequestParam("id") String id, @RequestParam("age") int age) {
		System.out.println("MVCController : test4");
		System.out.println("id : " + id);
		System.out.println("age : " + age);
		
		// Student 객체 생성 확인
		Student newStudent = new Student(id, age);
		System.out.println(newStudent);
	}
	
	// http://localhost:8082/mvc/test5?id=dev&age=28
	@RequestMapping(value = "/test5", method = RequestMethod.GET)
	public void test5(Student newStudent) {
		System.out.println("MVCController : test4");
		
		// Student 객체 생성 확인
		System.out.println(newStudent);
	}
	
	// http://localhost:8082/mvc/test6/emp/7369
	// emp 테이블의 SMITH를 검색할때 : ?empno=7369
	// 						 -> /emp/7369
	@RequestMapping(value = "/test6/emp/{empno}", method = RequestMethod.GET)
	public void test6(@PathVariable int empno) {
		System.out.println("MVCController : test6");
		
		// Student 객체 생성 확인
		System.out.println("empno : " + empno);
	}  
	
  // ----------------------------------------
  // return
  	// http://localhost:8082/mvc/test7
	@RequestMapping(value = "/test7", method = RequestMethod.GET)
	public void test7() {
		System.out.println("MVCController : test7");
		
//			return "test7";
	}
	
	// http://localhost:8082/mvc/test8?id=dev&age=28
	@RequestMapping(value = "/test8", method = RequestMethod.GET)
	public Student test8(@ModelAttribute Student newStudent) {
		System.out.println("MVCController : test8");
		
		// Student 객체 생성 확인
		System.out.println(newStudent);
		return newStudent;
	}
  
	// http://localhost:8082/mvc/test9?id=dev&age=28
	@RequestMapping(value = "/test9", method = RequestMethod.GET)
	public ModelAndView test9(Student newStudent) {
		System.out.println("MVCController : test9");
		
		ModelAndView mv = new ModelAndView();
		
		// Student 객체 생성 확인
		System.out.println(newStudent);
		mv.setViewName("test9");
		
		return mv;
	}
	
  // http://localhost:8082/mvc/test10
  // https://developer.mozilla.org/ko/docs/Web/HTTP/Basics_of_HTTP/MIME_types
	@RequestMapping(value = "/test10", method = RequestMethod.GET)
	public ResponseEntity<String> test10() {
		System.out.println("MVCController : test10");
		
		String data = "{\"id\":\"dev\"}";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/text;charset=UTF-8");
		
		return new ResponseEntity<String>(data, headers, HttpStatus.OK);
	
	}

	
	  
		

}
