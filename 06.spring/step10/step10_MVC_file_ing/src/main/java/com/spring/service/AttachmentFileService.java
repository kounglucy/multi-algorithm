package com.spring.service;

import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.spring.dto.AttachmentFile;
import com.spring.dto.Dept;
import com.spring.mapper.AttachmentFileMapper;
import com.spring.mapper.DeptMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AttachmentFileService {
	
	@Autowired
	AttachmentFileMapper attachmentFileMapper;
	
	// 객체
	public AttachmentFile getAttachmentFileByFileNo(int fileNo) throws Exception { 
		AttachmentFile attachmentFile = attachmentFileMapper.getAttachmentFileByFileNo(fileNo);
		
		if(attachmentFile == null) {
			throw new Exception("존재하지 않는 파일");
		}
		
		return attachmentFile;
	}
	
	// insert - 
	public boolean insertAttachmentFile(MultipartFile file, int deptno) throws SQLException, Exception {
		boolean result = false;
		
		if(file == null) {
			throw new Exception("파일 전달 오류 발생");
		}
		
		/* 파일을 저장하는 의미
		   1. DB 파일 정보 저장 - attFile 객체 생성 -> mapper -> db 저장
		   2. server에 파일이 실제로 저장  - multipartFile transferTo()
		 */
		
		/*
		 [추가 고민 사항]
1. 파일 삭제?!
	-> File.delete();

[실제 서비스시]
	-> 파일을 바로바로 삭제X
	-> 삭제 진행시, file 상태 컬럼을 두고 사용(삭제 되었다는 표기)
	-> 서비스를 이용할때는 삭제 표기가 있는 파일들은 사용하지 않도록 로직
	-> 일정 기간별로 삭제 진행

2. 부서만 또는 파일만 추가되는 경우?! -> 트랜잭션?!

트랜잭션 start()/begin()

1.부서 추가
2.파일 추가 : db추가 -> 서버 추가(throw)

트랜잭션 end()

	-> service를 활용하여 @Transactional 붙여 하나의 작업단위로 만들어 준다!
		 */
		String filePath = "C:\\multi\\00.spring";
		String attachmentOriginalFileName = file.getOriginalFilename();
		UUID uuid = UUID.randomUUID();
		String attachmentFileName = uuid.toString() + "_" + attachmentOriginalFileName;
		Long attachmentFileSize = file.getSize();
		
		AttachmentFile attachmentFile = AttachmentFile.builder()
													.attachmentOriginalFileName(attachmentOriginalFileName)
													.attachmentFileName(attachmentFileName)
													.attachmentFileSize(attachmentFileSize)
													.filePath(filePath)
													.deptno(deptno)
													.build();
		
		int res = attachmentFileMapper.insertAttachmentFile(attachmentFile);
		
		
		if(res != 0) {
			// 실제 서버에 저장되는 로직 추가!!! (attachmentFile.trasferTo())
			
			file.transferTo(new File(filePath + "\\" + attachmentFileName));
		    
			result = true;
		} else {
			throw new Exception("파일 DB 저장 실패");
		}
		
		return result;
	}
        public AttachmentFile getAttachmentFileByDeptno(int deptno) {
		
		AttachmentFile attachmentFile = null;
		
		attachmentFile = attachmentFileMapper.getAttachmentFileByDeptno(deptno);
		
		return attachmentFile;
	}
	
}
