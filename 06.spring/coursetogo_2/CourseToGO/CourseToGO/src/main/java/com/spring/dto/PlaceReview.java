package com.spring.dto;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
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
public class PlaceReview {
	
	private int placeReviewId; // 장소 리뷰 아이디
	private int userId; // 사용자
	private int placeId;   // 장소 아이디 
	private Date reviewDate; // 리뷰가 작성된 날짜 
	private int placeScore; // 리뷰 평점 
	

}
