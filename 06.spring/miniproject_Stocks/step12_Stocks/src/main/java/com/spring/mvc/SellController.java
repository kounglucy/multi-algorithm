package com.spring.mvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.dto.Stocks;
import com.spring.dto.Trading;
import com.spring.service.TradingService;

@Controller
public class SellController {
	
	@Autowired
	private TradingService service;
	
	@RequestMapping(value = "/sell", method = RequestMethod.POST)
	public String home(@RequestParam("volume") int volume, 
						@RequestParam("stocks_code") String stocks_code,
						@RequestParam("price") int price,
						HttpSession session, 
						Model model) {
		String user_id = session.getAttribute("user_id").toString();
		String user_name = session.getAttribute("user_name").toString();
		
		Trading newTrading = new Trading(user_name + 
											(service.getTradingCountById(user_id)+1),
											stocks_code,
											user_id,
											volume,
											volume*price,
											"sell");
		try {
			service.sellTrading(newTrading);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Stocks> stocks = service.getAllStocks();
		
		model.addAttribute("stocks", stocks);
		
		return "redirect:/index";
	}

}