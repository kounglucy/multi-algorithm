package com.spring.service;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.dto.Review;
import com.spring.dto.UpdateReview;
import com.spring.mapper.ReviewMapper;


@Service
public class ReviewService {
	
	@Autowired
	ReviewMapper mapper;
	
	/* 리뷰 게시글 전체 목록  */
	public List<Review> getallReviews() {
		return mapper.getallreview();
	}

	
	/* 리뷰 등록 */
	public int enrollReview(Review review) throws SQLException {
		
		int result = mapper.enrollReview(review);
		setRating(review.getCourseId());
		
		return result;
	}


	/* 리뷰 수정 */
	public boolean updateReview(Review review) throws SQLException, Exception {
		boolean result = false;
		
		setRating(review.getCourseId());
		int res = mapper.updateReview(review);
		
		if(res != 0) {
			result = true;
		} else {
			throw new Exception("리뷰 수정 실패");
		}
		
		return result;
	}
	
	/* 리뷰 삭제 */
	public boolean deleteReview(Review review) throws SQLException, Exception {
		boolean result = false;
		
		setRating(review.getCourseId());
		int res = mapper.deleteReview(review.getReviewId());
		
		if(res != 0) {
			result = true;
		} else {
			throw new Exception("리뷰 삭제 실패");
		}
		
		return result;
	}
	
	/* 리뷰 평균 별점 */
	public void setRating(int courseId) {
		
		Double ratingAvg = mapper.getRatingAverage(courseId);
		
		if(ratingAvg == null) {
			ratingAvg = 0.0;
		}
		
		ratingAvg = (double)(Math.round(ratingAvg*10)); // 별점 소수점 나타내기 
		ratingAvg = ratingAvg /10;
		
		UpdateReview ur = new UpdateReview();
		ur.setCourseId(courseId);
		ur.setRatingAvg(ratingAvg);
		
		mapper.updateRating(ur);
				
	}

	
}
