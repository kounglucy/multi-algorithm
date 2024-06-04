package com.spring.session;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.spring.session.dto.Student;


@Controller
@SessionAttributes({"grade","student"})
public class SessionController {
	
	private static final Logger logger = LoggerFactory.getLogger(SessionController.class);

	@RequestMapping(value = "/cookieTest.do", method = RequestMethod.GET)
	public String cookieTest(@CookieValue("id")String id){
		System.out.println(id);
        return "cookieView";
	}
	
	@RequestMapping(value = "/sessionTest1.do", method = RequestMethod.GET)
	public String sessionTest1(@SessionAttribute("name") String name, 
							   @SessionAttribute("age") int age,
							   HttpSession session) {
		System.out.println(name);
		System.out.println(age);
		
		session.setAttribute("grade", "junior");
		return "sessionView";
	}
	
	@RequestMapping(value = "/gradeDelete.do", method = RequestMethod.GET)
	public String gradeDelete(HttpSession session) {
		System.out.println(session.getAttribute("grade"));
    if(session != null) { 
//			session.invalidate();
			session.removeAttribute("grade");
		}
		return "sessionView";
	}
	
	@RequestMapping(value = "/sessionDelete.do", method = RequestMethod.GET)
	public String sessionDelete(HttpSession session) {
		if(session != null) {
			session.invalidate();
		}
		
		return "sessionView";
	}
  
	@RequestMapping(value = "/sessionTest2.do", method = RequestMethod.GET)
	public String sessionTest2(Student student) {
		System.out.println(student);
		return "sessionDTOView";
	}
	
	@RequestMapping(value = "/sessionDTODelete.do", method = RequestMethod.GET)
	public String sessionDTODelete(SessionStatus status) {
		status.setComplete();
		return "sessionDTOView";
	}
	
	
}
