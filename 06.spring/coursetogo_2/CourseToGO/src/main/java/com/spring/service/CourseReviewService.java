package com.spring.service;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.dto.CourseReview;
import com.spring.mapper.CourseReviewMapper;


@Service
public class CourseReviewService {
	
	@Autowired
	CourseReviewMapper mapper;

	
	/* 코스 리뷰 아이디 검색 */ 
	public CourseReview getCourseReviewByReviewId(int courseReviewId) throws Exception { 
		CourseReview coursereview = mapper.getCourseReviewByReviewId(courseReviewId)
							.orElseThrow(Exception::new);
		
		return coursereview; 
	}

	
	/* 코스 리뷰 등록 */
	public boolean insertCourseReview(CourseReview coursereview) throws SQLException, Exception {
		
		boolean result = false;
		
		int res = mapper.insertCourseReview(coursereview);
		
		if(res != 0) {
			result = true;
		} else {
			throw new Exception("리뷰 등록 실패");
		}
		
		return result;
	}

	
	/* 코스 리뷰 수정 */
	public boolean updateCourseReview(CourseReview coursereview) throws SQLException, Exception {
		boolean result = false;
		
		int res = mapper.updateCourseReview(coursereview);
		
		if(res != 0) {
			result = true;
		} else {
			throw new Exception("리뷰 수정 실패");
		}
		
		return result;
	}
	
	/* 코스 리뷰 삭제 */
	public boolean deleteCourseReviewByReviewId(int courseReviewId) throws SQLException, Exception {
		boolean result = false;
		
		int res = mapper.deleteCourseReviewByReviewId(courseReviewId);
		
		if(res != 0) {
			result = true;
		} else {
			throw new Exception("리뷰 삭제 실패");
		}
		
		return result;
	}
	
}
