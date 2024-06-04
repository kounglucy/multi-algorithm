package com.spring.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.Dept;
import com.spring.mapper.DeptMapper;
import com.spring.service.DeptService;

import lombok.RequiredArgsConstructor;

	

@RestController
@RequiredArgsConstructor // 반드시 내부에 주입해주세요, 생성자 주입 방식
public class DeptAPIController {
	
	@Autowired
	final DeptService deptService; //필드 주입 방식 총 3가지
	// 생성자, 필드, setmethod 주입 방식 그 중에 생성자 주입 방식이 안정성이 제일 높다
	
	//test
	final DeptMapper deptMapper;

	// http://localhost:8081/api/dynamic-sql
	// null 이 들어가도 문법적으로 이상 발생안한다!
	// 왜냐하면 mapper.xml에서 null을 무시
	@RequestMapping(value = "/api/dynamic-sql", method = RequestMethod.GET)
	public String getAPIDynamicSQL() throws Exception {
		System.out.println("getAPIDynamicSQL()");
		String result = "";
		//
		HashMap<String, Integer> map1 = new HashMap<String, Integer>();
		map1.put("deptno", 10);
		
		List<Dept> result1 = deptMapper.getDynamicDeptno(map1);
		result = result1.toString();
		
		// getDynamicChoose
		// SELECT * FROM dept WHERE dname = "SALES" and loc = "DALLAS" X
		// Choose : 첫 번째 혹은 두번째 혹은 세번째 조건 중에서 첫 번째로 만족하는 결과만 가져오는 동적 SQL
		HashMap<String, String> map2 = new HashMap<String, String>();
				map2.put("dname", "SALES");
				map2.put("loc", "DALLAS");
		
		List<Dept> result2 = deptMapper.getDynamicChoose(map2);
		result = result2.toString();
		
				
		// getDynamicWhereTrim , Trim 사용!
		// Trim은 조건에 따라 where을 추가 할 때 사용하는 태그
		// result3은 HashMap이고 result4는 객체!
		HashMap<String, String> map3 = new HashMap<String, String>();
				map3.put("dname", "SALES");
				map3.put("loc", "DALLAS");
		List<Dept> result3 = deptMapper.getDynamicWhereTrim(map3);
		
		// 조건에 <if test="dname != null"> dname이 널이 아니면 and로 넘어가는데 여기 null을 넣어서 조건 제낌
		List<Dept> result4 = deptMapper.getDynamicWhereTrim2(new Dept(0, null, "DALLAS"));
		
		
		// set
		// UPDATE dept SET loc = "LA" WHERE deptno = 40
		HashMap<String, Object> map5 = new HashMap<String, Object>();
		map5.put("deptno", 40);
		map5.put("dname", null);
		map5.put("loc", "BUSAN");
		
		Integer result5 = deptMapper.updateDynamicSet(map5);
		
		
		
		// foreach
		// SELECT * FROM dept WHERE deptno in (10, 20, 30)
		List<Integer> list6 = Arrays.asList(10, 20, 30, 40);
		List<Dept> result6 = deptMapper.getDynamicForeachDeptno(list6);
		
		
		
		
		// foreach : INSERT
		/*
		 INSERT ALL 
			INTO dept (deptno, dname, loc) VALUES (deptno, dname, loc)
			INTO dept (deptno, dname, loc) VALUES (deptno, dname, loc)
		 SELECT * FROM dual;
		*/
		
		List<Dept> list7 = Arrays.asList(
										new Dept(77, "PIZZ", "JEJU"), 
										new Dept(75, "DUPBA", "SEOUL")										
								);
		// 몇 개가 들어갔는지여서 Integer
		Integer result7 = deptMapper.insertDynamicForeachDeptList(list7);
//		
		
		
		
		result = result3.toString();
		result = result4.toString();
		result = result5.toString();
		result = result6.toString();
		result = result7.toString();
		return result;
	}
	//http://localhost:8081/api/dynamic-sql-delete
	@RequestMapping(value = "/api/dynamic-sql-delete", method = RequestMethod.GET)
	public Integer deleteAPIDynamicSQL() throws Exception {
		
		// 1개만 삭제
//		HashMap<String, Object> map = new HashMap<String, Object>();
//		map.put("deptno", 75);
//		map.put("dname", null);
//		map.put("loc", "SEOUL");
//		
//		Integer result1 = deptMapper.deleteDynamic(map);
//		int result = result1;
		
		
		HashMap<String, Object> map2 = new HashMap<String, Object>();
		map2.put("deptno", 77);
		map2.put("dname", "PIZZA");
		map2.put("loc", "SEOUL");
		
		Integer result2 = deptMapper.deleteDynamicUsingOr(map2);
		
		
		int result = result2;
		
		
		
		
		return result;
		
	}
	
	
	
	
	
	//
	@RequestMapping(value = "/api/dept/{deptno}",
					method = RequestMethod.GET)
	public Dept getAPIDeptByDeptno(@PathVariable int deptno) throws Exception {  //int deptno 가져오기
		System.out.println("getAPIDeptByDeptno()");
		Dept dept = deptService.getDeptByDeptno(deptno);
		if(dept != null) {
			throw new Exception("이미 존재하는 부서번호입니다.");
		}
		
		return dept;
		
	}
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<String> handleException(Exception e){
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
