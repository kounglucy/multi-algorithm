package naver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	// 제목
	private String title;
	
	// 네이버 도서정보 url
	private String link;
	
	// 섬네일 이미지 url
	private String image;
	
	// 저자명
	private String author;
	
	// 판매가격
	private String discount;
	
	// 출판사
	private String publisher;
	
	// 출간일
	private String pubdate;

	// ISBN
	private String isbn;
	
	// 네이버 도서 소개
	private String description;	
}
