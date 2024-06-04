package com.spring.mvc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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

import jdk.nashorn.internal.runtime.RewriteException;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class DeptAPIController {
	
	final DeptService deptService;
	
	// test
	final DeptMapper deptMapper;
	
	// http://localhost:8082/api/dynamic-sql
	@RequestMapping(value = "/api/dynamic-sql", method = RequestMethod.GET)
	public String getAPIDynamicSQL() throws Exception {
		System.out.println("getAPIDynamicSQL()");
		String result = "";
		
		// getDynamicDeptno
		HashMap<String, Integer> map1 = new HashMap<String, Integer>();
//		map1.put("deptno", null);
		
		List<Dept> result1 = deptMapper.getDynamicDeptno(map1);
//		result = result1.toString();
		
		// getDynamicChoose
		// SELECT * FROM dept WHERE dname = "SALES" OR loc = "DALLAS" X
		// Choose : 첫번째 혹은 두번째 혹은 세번째 조건중에서 첫번째로 만족하는 결과만 가져오는 동적 SQL
		HashMap<String, String> map2 = new HashMap<String, String>();
				map2.put("dname", "SALES");
				map2.put("loc", "DALLAS");
		
//		List<Dept> result2 = deptMapper.getDynamicChoose(map2);
		
		// getDynamicChoose
		// SELECT * FROM dept WHERE dname = "SALES" OR loc = "DALLAS" X
		// Choose : 첫번째 혹은 두번째 혹은 세번째 조건중에서 첫번째로 만족하는 결과만 가져오는 동적 SQL
		// HashMap
		HashMap<String, String> map3 = new HashMap<String, String>();
				map3.put("dname", null);
				map3.put("loc", "DALLAS");
		List<Dept> result3 = deptMapper.getDynamicWhereTrim(map3);
		
		// Dept 객체
//		List<Dept> result4 = deptMapper.getDynamicWhereTrim2(new Dept(0, null, "DALLAS"));
		
		// set
		// UPDATE dept SET loc = "LA" WHERE deptno = 40
		HashMap<String, Object> map5 = new HashMap<String, Object>();
				map5.put("deptno", 40);
				map5.put("dname", null);
				map5.put("loc", "LA");
		Integer result5 = deptMapper.updateDynamicSet(map5);
		
		// foreach : SELECT, UPDATE, DELETE
		// SELECT * FROM dept WHERE deptno IN (10, 20, 30)
		List<Integer> list6 = Arrays.asList(10, 20, 30);
		List<Dept> result6 = deptMapper.getDynamicForeachDeptno(list6);
		
		// foreach : INSERT
		/*
		 INSERT ALL 
			INTO dept (deptno, dname, loc) VALUES (deptno, dname, loc)
			INTO dept (deptno, dname, loc) VALUES (deptno, dname, loc)
		 SELECT * FROM dual;
		 */
		List<Dept> list7 = Arrays.asList(
										new Dept(77, "PIZZA", "JEJU"), 
										new Dept(78, "DUPBAB", "SEOUL")
								);
		Integer result7 = deptMapper.insertDynamicForeachDeptList(list7);
		
		result = result7.toString();
		return result;
	}	

	// http://localhost:8082/api/dept/{deptno}
	@RequestMapping(value = "/api/dept/{deptno}", method = RequestMethod.GET)
	public Dept getAPIDeptByDeptno(@PathVariable int deptno) throws Exception {
		System.out.println("getAPIDeptByDeptno()");
		Dept dept = deptService.getDeptByDeptno(deptno);
		
		if(dept != null) {
			throw new Exception("이미 존재하는 부서번호 입니다.");
		}
		
		return dept;
	}
	
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<String> handleException(Exception e){
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
