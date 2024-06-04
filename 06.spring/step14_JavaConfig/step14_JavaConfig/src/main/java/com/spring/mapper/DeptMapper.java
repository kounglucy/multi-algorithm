package com.spring.mapper;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

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
	public int updateDnameAndLoc(Dept dept) throws SQLException; 

	// delete - dept
	public int deleteDeptByDeptno(int deptno) throws SQLException;
	
	// getDynamicDeptno
	public List<Dept> getDynamicDeptno(HashMap<String, Integer> map1) throws SQLException;

	// getDynamicChoose
	public List<Dept> getDynamicChoose(HashMap<String, String> map2)throws SQLException;
	
	// getDynamicWhereTrim
	public List<Dept> getDynamicWhereTrim(HashMap<String, String> map3)throws SQLException;

	// getDynamicWhereTrim2
	public List<Dept> getDynamicWhereTrim2(Dept dept);

    // updateDynamicSet
	public Integer updateDynamicSet(HashMap<String, Object> map5);

	// getDynamicForeachDeptno
    public List<Dept> getDynamicForeachDeptno(List<Integer> list6);

    // insertDynamicForeachDeptList
 	public Integer insertDynamicForeachDeptList(List<Dept> list7);
	
	
}
