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
	
	// insert - Dept
	public boolean insertAttachmentFile(MultipartFile file, int deptno) throws Exception {
		boolean result = false;
		
		if(file == null) {
			throw new Exception("파일 전달 오류 발생");
		}
		
		
		/* 파일을 저장하는 의미
		 * 1. DB 파일 정보 저장 - attFile 객체 생성 -> mapper -> db저장
		 * 2. server에 파일이 실제로 저장 - multipartFile transferTo()
		 * 
		 */
		
		String filePath = "C:\\multi\\00.spring";
		String attachmentOriginalFileName = file.getOriginalFilename();
		UUID uuid = UUID.randomUUID();
		String attachmentFileName = uuid.toString() + "_" + attachmentOriginalFileName;
		Long attachmentFileSize = file.getSize();
		
		//빌더 패턴! 생성자 필요없음
		AttachmentFile attachmentFile = AttachmentFile.builder().attachmentOriginalFileName(attachmentOriginalFileName)
																.attachmentFileName(attachmentFileName)
																.attachmentFileSize(attachmentFileSize)
																.filePath(filePath)
																.deptno(deptno)
																.build();
		

		int res = attachmentFileMapper.insertAttachmentFile(attachmentFile);
		
		
		if(res != 0) {
			// 실제 서버에 저장되는 로직 추가!!! (attachmentFile.trasferTo())
			file.transferTo(new File(filePath + "\\" + attachmentFileName)); // 서버에 저장하는 로직 즉, 내가 지정한 위치에 파일을 저장하는가
			
			result = true;
		} else {
			throw new Exception("부서 생성 실패");
		}
		
		return result;
	}

	public AttachmentFile getAttachmentFileByDeptno(int deptno) {
		
		AttachmentFile attachmentFile = null;
		
		attachmentFile = attachmentFileMapper.getAttachmentFileByDeptno(deptno);
		
		return attachmentFile;
	}
	
}
