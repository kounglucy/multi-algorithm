package com.spring.pagination.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchKeyword extends PageRequestDTO {
	
	// 검색 키워드
	private String keyword;
	
}
