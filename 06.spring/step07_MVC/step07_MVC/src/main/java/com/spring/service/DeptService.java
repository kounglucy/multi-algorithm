package com.spring.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dto.Dept;
import com.spring.mapper.DeptMapper;

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
	public Dept getDeptByDeptno(int deptno) { 
		return mapper.getDeptByDeptno(deptno);
	}
	
	// List - Map
	public List<HashMap<String, Object>> getAllDeptsHashMap() {
		return mapper.getAllDeptsHashMap();
	}

	// HashMap
	public HashMap<String, Object> getDeptHashMap(int deptno) {
		return mapper.getDeptHashMap(deptno);
	}
	
	public String getDnameByDeptnoAndLoc(int deptno, String loc) {
//		return mapper.getDnameByDeptnoAndLoc(deptno, loc);
		// ver1 : HashMap
//		HashMap<String, Object> deptnoAndLoc = new HashMap<String, Object>();
//		deptnoAndLoc.put("deptno", deptno);
//		deptnoAndLoc.put("loc", loc);
		
//		return mapper.getDnameByDeptnoAndLoc(deptnoAndLoc);
		
		// ver2 : Param
		return mapper.getDnameByDeptnoAndLoc(deptno, loc);
	}

	// String
	public String getDnameByDeptno(int deptno) {
		String dname = "";
		
		try {
			dname = mapper.getDnameByDeptno(deptno);
			sqlSession.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return dname;
	};
	
	// insert - Dept
	public void insertDept(Dept dept) {
		mapper.insertDept(dept);
	}

	
}
