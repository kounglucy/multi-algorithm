package com.spring.session;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String loginForm() {
		return "login";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(@RequestParam("id") String id, 
						@RequestParam("pw") String pw,
						HttpSession session) {
		
		if("dev".equals(id) && "it".equals(pw)) {
			session.setAttribute("userId", id);
		}

		return "home";
	}
  
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String login(HttpSession session) {
		
		if(session != null ) {
			session.invalidate();
		}

		return "home";
	}
}

