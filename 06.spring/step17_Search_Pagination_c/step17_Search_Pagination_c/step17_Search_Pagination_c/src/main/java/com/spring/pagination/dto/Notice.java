package com.spring.pagination.dto;

import com.spring.pagination.dto.Notice;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Notice {
	
	// 번호
	// oracle sequence 활용 가능!
	// 주의 : foreach 내에서는 sequence 사용 불가능!
	private long no;
	
	// 작성자id
	private String userId;

	// 작성자명
	private String userName;

	// 제목
	private String title;

	// 내용
	private String content;

	// 조회수
	private int hit;
	  
	@Builder
	public Notice(int no, String userId, String userName, String title, String content, int hit) {
		super();
		this.no = no;
		this.userId = userId;
		this.userName = userName;
		this.title = title;
		this.content = content;
		this.hit = hit;
	}
}
