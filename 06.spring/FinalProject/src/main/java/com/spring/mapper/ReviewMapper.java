package com.spring.mapper;

import java.sql.SQLException;
import java.util.List;
import com.spring.dto.Review;
import com.spring.dto.UpdateReview;

// 댓글 정보를 등록하는 테이블 
public interface ReviewMapper {
	
	
	/* 리뷰 작성하기 */
	public int enrollReview(Review review) throws SQLException;
	
	/* 리뷰 수정하기 */
    public int updateReview(Review review) throws SQLException;
    
	/* 리뷰  삭제하기 */
	public int deleteReview(int ReviewId)throws SQLException;
	
	/* 리뷰 게시글 전체 목록  */
	public List<Review> getallreview();
	
	/* 평점 평균 구하기 */
	public Double getRatingAverage(int courseId);
	
	/* 평점 평균 반영하기 */
	public int updateRating(UpdateReview updatereview);


}
