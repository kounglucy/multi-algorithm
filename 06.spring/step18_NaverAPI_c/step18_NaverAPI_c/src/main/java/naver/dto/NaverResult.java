package naver.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NaverResult {
	// 검색 결과 생성 시간
	private String lastBuildDate;
	
	// 검색 결과 개수
	private int total;
	
	// 검색 시작 위치
	private int start;
	
	// 한 번에 표시할 검색 결과 개수
	private int display;
	
	// 개별 검색 결과
	private List<Book> items;
}
