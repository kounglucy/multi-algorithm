package com.spring.mvc;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.dto.Dept;

@Controller
public class DeptController {
	
	// http://localhost:8082/getTest
	@RequestMapping(value = "/getTest", method = RequestMethod.GET)
	@ResponseBody
	public String getTest() {
		
		return "getTest";
	}
	
	// http://localhost:8082/getTest2
	@RequestMapping(value = "/getTest2", 
					method = RequestMethod.GET,
					produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public Dept getTest21() {
		
		Dept dept = new Dept(50, "DEV", "IT");
    /* 예상결과 --> 오류 발생
		 * -> https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind/2.14.3
		 * -> 다시 실행 : 정상 출력
		 	{
		 		"deptno" : 50,
		 		"dname" : "DEV",
		 		"loc" : "IT
		 	}
		 */
		return dept;
	}  
	
	// 버튼 클릭시 에러 발생 : CORS 
	// http://ip주소:포트 번호까지 동일해야만 요청한 결과값을 돌려주는 정책
	// 이 정책을 모두다 허용하기 위해서 backend 요청 메소드에 @CrossOrigin(origins = {"*"}) 추가

		// http://localhost:8082/getTest2
		@CrossOrigin(origins = {"*"})
		@RequestMapping(value = "/getTest2", 
						method = RequestMethod.GET,
						produces = {MediaType.APPLICATION_JSON_VALUE})
//		@ResponseBody
		public Dept getTest2() {
			
			Dept dept = new Dept(50, "DEV", "IT");
			
			/* 예상결과 --> 오류 발생
			 * -> https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind/2.14.3
			 * -> 다시 실행 : 정상 출력
			 	{
			 		"deptno" : 50,
			 		"dname" : "DEV",
			 		"loc" : "IT
			 	}
			 */
			
			return dept;
		}
  
}
