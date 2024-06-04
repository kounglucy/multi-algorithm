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
public class Review {
	private int reviewId; //리뷰 아이디
	private int courseId; // 코스아이디
	private String userId;   // 사용자
	private String content; // 리뷰내용 
	
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul")
	private Date reDate; // 리뷰가 작성된 날짜 
	private double rating; // 리뷰 평점 
	
}
