package com.spring.mvc;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dto.Stocks;
import com.spring.dto.Trading;
import com.spring.service.TradingService;

@Controller
public class SelectController {
	
	@Autowired
	private TradingService service;
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(Model model) {
		
		List<Stocks> stocks = service.getAllStocks();
		
		model.addAttribute("stocks", stocks);
		
		return "index";
		
	}
	
	//http://localhost:8082/stocks/1
		@RequestMapping(value = "/stocks/{stocks_code}", method = RequestMethod.GET)
		public String mainDetail(@PathVariable String stocks_code,HttpSession session,
									Model model) {
				
			Stocks stocks = service.getStocksByCode(stocks_code);
			List<Trading> trading= service.getTradingByStocks_code(stocks_code);

			
			int index1 = service.getTradingByStocks_code(stocks_code).size();
			
			int volume = 0;
			for(int i = 0;i<index1;i++) {
				volume += service.getTradingByStocks_code(stocks_code).get(i).getVolume();
			}
			
			int index2 = service.getAllTrading().size();
			
			int totalvolume = 0;
			for(int i = 0;i<index2;i++) {
				totalvolume += service.getAllTrading().get(i).getVolume();
			}

			

			model.addAttribute("stocks", stocks);
			model.addAttribute("trading",trading);
			model.addAttribute("volume",volume);
			model.addAttribute("totalvolume",totalvolume);
			return "indexDetail";
			
		}
	
}
