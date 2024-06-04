package com.spring.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dto.Dept;
import com.spring.mapper.DeptMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DeptService {
	
	@Autowired
	DeptMapper mapper;
	
	@Autowired
	SqlSession sqlSession;
	
	// List
	public List<Dept> getAllDepts() {
		return mapper.getAllDepts();
	}
	
	// 객체
	public Dept getDeptByDeptno(int deptno) throws Exception { 
		Dept dept = mapper.getDeptByDeptno(deptno)
				    .orElseThrow(Exception::new);
				
//			  dept가 존재한다면 if문은 쓰지않고 orElseThrow로 넘겨준다.
//			  if(dept == null) {
//			     throw new Exception("");
//			  }
		
		return dept; 
	}

	// insert - Dept
	public boolean insertDept(Dept dept) throws SQLException, Exception {
		boolean result = false;
		
		int res = mapper.insertDept(dept);
		
		if(res != 0) {
			result = true;
		} else {
			throw new Exception("부서 생성 실패");
		}
		
		return result;
	}
	
	// update-dept
	public boolean updateDnameAndLoc(Dept dept) throws SQLException, Exception {
		boolean result = false;
		
		int res = mapper.updateDnameAndLoc(dept);
		
		if(res != 0) {
			result = true;
		} else {
			throw new Exception("부서 수정 실패");
		}
		
		return result;
	}
	
	// delete - dept
	public boolean deleteDeptByDeptno(int deptno) throws SQLException, Exception {
		boolean result = false;
		
		int res = mapper.deleteDeptByDeptno(deptno);
		
		if(res != 0) {
			result = true;
		} else {
			throw new Exception("부서 삭제 실패");
		}
		
		return result;
	}

	
}
