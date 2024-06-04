package com.spring.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

import com.spring.dto.AttachmentFile;

@Mapper
public interface AttachmentFileMapper {
	
	AttachmentFile getAttachmentFileByFileNo(int fileNo) throws SQLException;

	int insertAttachmentFile(AttachmentFile attachmentFile) throws SQLException; // int 인 이유는 갯수로 넘어오기 때문?

	AttachmentFile getAttachmentFileByDeptno(int deptno);
	
}
