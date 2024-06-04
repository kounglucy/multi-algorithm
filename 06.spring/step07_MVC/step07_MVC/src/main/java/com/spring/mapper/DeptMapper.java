package com.spring.mapper;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.spring.dto.Dept;

@Mapper
public interface DeptMapper {
	
	// List
	public List<Dept> getAllDepts();

	// 객체 - Dept
	public Dept getDeptByDeptno(int deptno);
	
	// HashMap
	public HashMap<String, Object> getDeptHashMap(int deptno);
	
	// List - Map
	public List<HashMap<String, Object>> getAllDeptsHashMap();
	
	// String - dname
	public String getDnameByDeptno(int deptno) throws SQLException;
	
//	public Dept getDnameByDeptnoAndLoc(int deptno, String loc);
	// ver1 : hashmap
//	public String getDnameByDeptnoAndLoc(HashMap<String, Object> deptnoAndLoc);
	
	// ver2 : Param
//	public String getDnameByDeptnoAndLoc(int deptno, String loc); // 에러발생 :Parameter 'deptno' not found
	public String getDnameByDeptnoAndLoc(@Param("deptno") int deptno, @Param("loc") String loc); 
	
	// insert - Dept
	public boolean insertDept(Dept dept);
}
