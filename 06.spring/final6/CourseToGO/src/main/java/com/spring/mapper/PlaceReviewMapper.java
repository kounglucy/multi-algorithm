package com.spring.mapper;

import java.sql.SQLException;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import com.spring.dto.PlaceReview;


@Mapper
public interface PlaceReviewMapper {
	
	/* 장소 리뷰 아이디 검색 */
	public Optional<PlaceReview> getPlaceReviewByPlaceId (int placeReviewId);
	
	/* 장소 리뷰 별점 매기기 */
	public int insertPlaceReview(PlaceReview placereview) throws SQLException;
	
	/* 장소 리뷰 수정하기 */
    public int updatePlaceReview(PlaceReview placereview) throws SQLException;
    
	/* 장소 리뷰  삭제하기 */
	public int deletePlaceReviewByPlaceId(int placeReviewId)throws SQLException;
	

}
