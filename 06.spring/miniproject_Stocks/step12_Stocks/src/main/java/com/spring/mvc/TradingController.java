package com.spring.mvc;

import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.dto.Investor;
import com.spring.dto.Stocks;
import com.spring.dto.Trading;
import com.spring.service.TradingService;

@Controller
public class TradingController {
	
	@Autowired
	private TradingService service;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String home(Model model) {

		List<Trading> tradingList = service.getAllTrading();	
		List<Stocks> stocksList = service.getAllStocks();
  	
		model.addAttribute("tradingList", tradingList);
		model.addAttribute("stocksList", stocksList);
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm(Locale locale, Model model) {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("user_id") String user_id,
						@RequestParam("password") String password,
						HttpSession session,
						Model model){
		String view = "login";
		
		Investor investor;
		try {
			investor = service.getInvestorByUserIdAndPassword(user_id, password);
			session.setAttribute("user_id", investor.getUser_id());
			session.setAttribute("user_name", investor.getUser_name());
			session.setAttribute("user_money", investor.getUser_money());
			
			view = "redirect:/index";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return view;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		
		if(session != null) {
			session.invalidate();
		}
		
		return "login";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String signupForm(HttpSession session) {
		return "register";
	}
	
	@RequestMapping(value = "/tables", method = RequestMethod.GET)
	public String tables(Model model) {
		
		List<Trading> tradingList = service.getAllTrading();
		
		model.addAttribute("tradingList", tradingList);
		
		return "tables";
	}
	
}
