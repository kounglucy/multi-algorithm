package com.spring.service;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.dto.PlaceReview;
import com.spring.mapper.PlaceReviewMapper;


@Service
public class PlaceReviewService {
	
	@Autowired
	PlaceReviewMapper mapper;
	
	/* 장소 리뷰 아이디 검색 */ 
	public PlaceReview getPlaceReviewByPlaceId(int placeReviewId) throws Exception { 
		PlaceReview coursereview = mapper.getPlaceReviewByPlaceId(placeReviewId)
							.orElseThrow(Exception::new);
		
		return coursereview; 
	}

	
	/* 장소 리뷰 등록 */
	public boolean insertPlaceReview(PlaceReview placereview) throws SQLException, Exception {
		
		boolean result = false;
		
		int res = mapper.insertPlaceReview(placereview);
		
		if(res != 0) {
			result = true;
		} else {
			throw new Exception("장소 리뷰 등록 실패");
		}
		
		return result;
	}

	
	/* 장소 리뷰 수정 */
	public boolean updatePlaceReview(PlaceReview placereview) throws SQLException, Exception {
		boolean result = false;
		
		int res = mapper.updatePlaceReview(placereview);
		
		if(res != 0) {
			result = true;
		} else {
			throw new Exception("장소 리뷰 수정 실패");
		}
		
		return result;
	}
	
	/* 장소 리뷰 삭제 */
	public boolean deletePlaceReviewByPlaceId(int placeReviewId) throws SQLException, Exception {
		boolean result = false;
		
		int res = mapper.deletePlaceReviewByPlaceId(placeReviewId);
		
		if(res != 0) {
			result = true;
		} else {
			throw new Exception("장소 리뷰 삭제 실패");
		}
		
		return result;
	}
	
}
