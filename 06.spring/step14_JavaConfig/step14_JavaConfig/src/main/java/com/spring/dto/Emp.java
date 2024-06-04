package com.spring.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString 
public class Emp {
	private int empno;
	private String ename;
	private String job;
	private Integer mgr;
	private Date hiredate;
	private Float sal;
	private Float comm;
	private int deptno;
}
