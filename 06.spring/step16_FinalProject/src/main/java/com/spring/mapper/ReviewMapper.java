package com.spring.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import com.spring.dto.Review;

@Mapper
public interface ReviewMapper {
	
	/* 리뷰 작성하기 */
	public int enrollReview(Review review);
	
	/* 리뷰 수정하기 */
	public Review getupdateReview(int reviewId);
	
	/* 평점 평균 구하기 */
	public Double getRatingAverage(int reviewId);
	

	
	
}
