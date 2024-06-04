package com.spring.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AttachmentFile {
	private int attachmentFileNo; 				// 파일 번호
	private String filePath;					// 파일 저장 경로(base경로 + 새로운 폴더 경로)
	private String attachmentFileName;			// 파일명(UUID + 원본파일명)
	private String attachmentOriginalFileName;	// 원본 파일명
	private Date registeredDate;				// 파일 등록 일자
	private Long attachmentFileSize; 			// 파일 크기
	private int deptno; 						// 부서 번호

	
	// 빌더 패턴 : 파일 번호와 파일 등록 일자는 DB에서 생성해서 넘겨줘야 하기 때문에 현재의 생성자에서는 불필요
	// 		  -> 필요한 필드만 사용하여 객체를 생성하기 위해 빌더가 필요
	@Builder
	public AttachmentFile(int attachmentFileNo, String filePath, String attachmentFileName,
			String attachmentOriginalFileName, Date registeredDate, Long attachmentFileSize, int deptno) {
		this.attachmentFileNo = attachmentFileNo;
		this.filePath = filePath;
		this.attachmentFileName = attachmentFileName;
		this.attachmentOriginalFileName = attachmentOriginalFileName;
		this.registeredDate = registeredDate;
		this.attachmentFileSize = attachmentFileSize;
		this.deptno = deptno;
	}
}
