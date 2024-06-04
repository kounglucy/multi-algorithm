package com.spring.service;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.dto.Review;
import com.spring.mapper.ReviewMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DeptService {
	
	@Autowired
	ReviewMapper mapper;
	
	// List
	public List<Review> getAllreview() {
		return mapper.getAllreview();
	}

	// 객체
	public Review getDeptByDeptno(int deptno) throws Exception { 
		Review dept = mapper.getDeptByDeptno(deptno)
							.orElseThrow(Exception::new);
						
//		if(dept == null) {
//			throw new Exception("");
//		}
		
		return dept; 
	}
	
	// insert - Dept
	public boolean insertDept(Review dept) throws SQLException, Exception {
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
	public boolean updateDnameAndLoc(Review dept) throws SQLException, Exception {
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
