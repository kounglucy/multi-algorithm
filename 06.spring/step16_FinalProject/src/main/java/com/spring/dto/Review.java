package com.spring.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
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
	private int reviewId; //리뷰의 아이디
	private int userId;   // 리뷰를 작성한 사용자의 아이디
	private int courseId; // 리뷰의 대상인 코스의 아이디
	private String content; // 리뷰내용 
	private Date reviewDate; // 리뷰가 작성된 날짜 
	private double rating; // 리뷰 평점 
}