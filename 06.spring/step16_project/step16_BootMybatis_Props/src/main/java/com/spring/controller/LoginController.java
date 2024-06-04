package com.spring.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dto.Emp;
import com.spring.service.EmpService;

@Controller
public class LoginController {
	
	@Autowired
	EmpService empService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {
		return "login";
	}
	
	// version 1
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String login(@RequestParam("empno") int empno,
//						@RequestParam("ename") String ename,
//						HttpSession session,
//						Model model) {
//		String view = "error";
//		
//		Emp emp = null;
//		try {
//			 emp = empService.getEmpByEmpnoAndEname(empno, ename);
//			 
//			 // session - 1) userId : empno , 2) userName : ename
//			 session.setAttribute("userId", emp.getEmpno());
//			 session.setAttribute("userName", emp.getEname());
//			 
//			 view = "redirect:/main";
//		} catch (Exception e) {
//			e.printStackTrace();
//			return view;
//		}
//		
//		return view;
//	}
	
	
	// verion2 : exception 테스트 
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginTest(@RequestParam("empno") int empno,
						@RequestParam("ename") String ename,
						HttpSession session,
						Model model) throws SQLException, Exception {
		String view = "error";
		
		Emp emp = empService.getEmpByEmpnoAndEname(empno, ename);
		 
		 session.setAttribute("userId", emp.getEmpno());
		 session.setAttribute("userName", emp.getEname());
			 
		 view = "redirect:/main";
		return view;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		
		if(session != null) {
			session.invalidate();
		}
		
		return "redirect:/main";
	}
	
//	// 예외 step02 : LoginController 내부에서 발행하는 모든 NPE 처리
//	@ExceptionHandler({Exception.class})
//	public ModelAndView nullPointerExceptionHandler(Exception exception) {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("exception", exception);
//		mv.setViewName("error");
//		return mv;
//	}
	
}
