package com.spring.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dto.Dept;
import com.spring.dto.Emp;
import com.spring.mapper.DeptMapper;
import com.spring.mapper.EmpMapper;

@Service
public class EmpService {
	
	@Autowired
	EmpMapper empMapper;
	
	// 객체
	public Emp getEmpByEmpnoAndEname(int empno, String ename) throws SQLException, Exception { 
		
		Emp emp = empMapper.getEmpByEmpnoAndEname(empno, ename);
		
		if(emp == null) {
			throw new Exception("해당 사원 존재하지 않음");
		}
		
		return emp;
	}
	
	
	public Emp getEmpByDeptno(int empno) throws Exception {
		Emp emp = empMapper.getEmpByEmpno(empno);
		
		if(emp == null) {
			throw new Exception("존재하지 않는 사원 입니다.");
		}
		
		return emp;
	}
}
