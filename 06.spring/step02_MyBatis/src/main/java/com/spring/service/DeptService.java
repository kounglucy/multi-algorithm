package com.spring.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.Dept;
import com.spring.mapper.DeptMapper;

@Service
public class DeptService {
	
	@Autowired
	DeptMapper deptMapper;
	
	// getAllDepts()
	public List<Dept> getAllDepts() {
		return deptMapper.getAllDepts();
	}
	
	// getDeptByDeptno
	public Dept getDeptByDeptno(int deptno) {
		return deptMapper.getDeptByDeptno(deptno);
	}
	
	// getDnameByDeptno
	public String getDnameByDeptno(int deptno) {
		return deptMapper.getDnameByDeptno(deptno);
	}
    
	// getDnameByDeptnoAndLoc
	public String  getDnameByDeptnoAndLoc(int deptno, String loc) {
		return deptMapper. getDnameByDeptnoAndLoc(deptno,loc);
	}

	// getDnameByDeptnoAndLocMap
	public String getDnameByDeptnoAndLocMap(HashMap<String, Object> hashmap) {
		return deptMapper.getDnameByDeptnoAndLocMap(hashmap);
	}
	
	// getAllDeptsHashMap
	public List<HashMap<String, Object>> getAllDeptsHashMap() {
		return deptMapper.getAllDeptsHashMap();
	}

}