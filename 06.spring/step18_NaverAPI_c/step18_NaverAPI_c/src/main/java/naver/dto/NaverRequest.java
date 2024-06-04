package naver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NaverRequest {
	
	private String query;
	private Integer display;
	private Integer start;
	private String sort;
	
	public NaverRequest() {
		this.display = 10;
		this.start = 1;
		this.sort = "sim";
	}
}
