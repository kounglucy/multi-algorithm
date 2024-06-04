package com.spring.mvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.service.DeptService;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private DeptService service;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		logger.debug("logger debug");
		logger.warn("logger warn");
		logger.trace("logger trace");
		logger.error("logger error");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/mybatis", method = RequestMethod.GET)
	public void home() {
//		System.out.println(service.getAllDepts());
//		System.out.println(service.getDeptByDeptno(10));
		
//		System.out.println(service.getAllDeptsHashMap());
//		System.out.println(service.getDeptHashMap(10));

//		System.out.println(service.getDnameByDeptno(10));
		System.out.println(service.getDnameByDeptnoAndLoc(10, "NEW YORK"));
		
//		service.insertDept(new Dept(98, "it", "seoul"));
		
	}
	
	
}
