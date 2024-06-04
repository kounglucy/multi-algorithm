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
public class CourseReview {
	
	private int courseReviewId; //리뷰 아이디
	private int courseId; // 코스아이디
	private int userId;   // 사용자
	private String content; // 리뷰내용 
	private int courseScore; // 리뷰 평점 
	private Date reviewDate; // 리뷰 날짜 

}
