package com.spring.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dto.AttachmentFile;
import com.spring.service.AttachmentFileService;

@Controller
public class AttachmentFileController {
	
	@Autowired
	AttachmentFileService fileService;
	
	@RequestMapping(value = "/download/file/{fileNo}", method = RequestMethod.GET)
	public ResponseEntity<Resource> downloadFile(@PathVariable int fileNo) {
		System.out.println(fileNo);
		
		/* 1. filNo -> db 해당 파일이 서버에 존재 여부 확인
		 * 2. 		-> 존재 한다면 : file -> resource
		 * 3. ResponseEntity<Resource>, header의 ContentType, HttpSTATUS.OK
		 */
		AttachmentFile attachmentFile = null;
		Resource resource = null;
		HttpHeaders headers = null;
		try {
			attachmentFile = fileService.getAttachmentFileByFileNo(fileNo);
			
			Path path = Paths.get(attachmentFile.getFilePath() + "\\" + attachmentFile.getAttachmentFileName());
			resource = new InputStreamResource(Files.newInputStream(path));
			
			// 
			headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.setContentDisposition(ContentDisposition
														.builder("attachment")
														.filename(attachmentFile.getAttachmentOriginalFileName())
														.build());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}
	
	
}
