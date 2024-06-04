package com.spring.mapper;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.spring.dto.Dept;

@Mapper
public interface DeptMapper {
	
	// List
	public List<Dept> getAllDepts();

	// 객체 - Dept
	public Optional<Dept> getDeptByDeptno(int deptno);

	// insert - Dept
	public int insertDept(Dept dept) throws SQLException;
	
	// update - Dept
	public int updateDnameAndLoc (Dept dept) throws SQLException; 

	// delete - dept
	public int deleteDeptByDeptno(int deptno) throws SQLException;

	
	
}
