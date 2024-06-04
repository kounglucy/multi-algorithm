package com.spring.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.spring.dto.Emp;

@Mapper
public interface EmpMapper {
	
	// 객체 - Emp
	public Emp getEmpByEmpnoAndEname(@Param("empno") int empno, @Param("ename") String ename) throws SQLException;
	
}
