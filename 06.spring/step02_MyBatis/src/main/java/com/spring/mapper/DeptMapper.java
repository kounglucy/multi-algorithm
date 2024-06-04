package com.spring.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.spring.dto.Dept;

@Mapper
public interface DeptMapper {

	// getAllDepts
	List<Dept> getAllDepts();
	
	// getDeptByDeptno
	Dept getDeptByDeptno(int deptno);
	
	// getDnameByDeptno
	String getDnameByDeptno(int deptno);
	
	// getDnameByDeptnoAndLoc
    String getDnameByDeptnoAndLoc(@Param ("deptno") int deptno,@Param ("loc") String loc);
  
	// getDnameByDeptnoAndLocMap
	String getDnameByDeptnoAndLocMap(HashMap<String, Object> hashmap);
	
	// getAllDeptsHashMap
	List<HashMap<String, Object>> getAllDeptsHashMap();  
}
