package com.spring.pagination.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class PageRequestDTO {
	
	// 현재 페이지 번호
	private int pageNum;
	
	// 페이지당 출력할 데이터 개수
	private int amount;
	
	// 추가
	// 검색 키워드
	private String keyword;
	
	public PageRequestDTO() {
		this(1, 10);
	}
	
	// 추가
	public PageRequestDTO(int pageNum, int amount) {
		super();
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	// keyword 추가 전
//	@Builder
//	public PageRequestDTO(int pageNum, int amount) {
//		super();
//		this.pageNum = pageNum;
//		this.amount = amount;
//	}
	
	// keyword 추가 후
	@Builder
	public PageRequestDTO(int pageNum, int amount, String keyword) {
		super();
		this.pageNum = pageNum;
		this.amount = amount;
		this.keyword = keyword;
	}
}