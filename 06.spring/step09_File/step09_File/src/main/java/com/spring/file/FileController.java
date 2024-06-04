package com.spring.file;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class FileController {
	
	@RequestMapping(value = "/file-test", method = RequestMethod.GET)
	public String home() {
		log.info("FileContoller : /file-test");
		return "fileTest";
	}
	
	@PostMapping(value = "/file-upload")
	public void saveFile(@RequestParam("file") MultipartFile file) {
		log.info("FileContoller : /file-upload");
		System.out.println(file);
	}
	
	
	
}
