package com.spring.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.Investor;
import com.spring.dto.Stocks;
import com.spring.dto.Trading;
import com.spring.mapper.TradingMapper;

@Service
public class TradingService {
	
	@Autowired
	TradingMapper mapper;
	
	public Investor getInvestorByUserIdAndPassword(String user_id, String password) throws Exception {
		Investor investor = mapper.getInvestorByUserIdAndPassword(user_id,password);
		
		if(investor == null) {
			throw new Exception("해당 회원 미존재");
		}
		
		return investor;
	}
	
	public List<Trading> getAllTrading() {
		return mapper.getAllTrading();
	}
	
	public List<Stocks> getAllStocks() {
		return mapper.getAllStocks();
	}
	
	public List<Trading> getTradingByStocks_code (String stocks_code) {
		List<Trading> trading = mapper.getTradingByStocks_code(stocks_code);
		return trading;
	}

	public Stocks getStocksByCode(String stocks_code) {
		Stocks stocks = mapper.getStocksByCode(stocks_code);
		return stocks;
	}
	
	// 거래내역 counting
	public int getTradingCountById(String user_id) {
		int count = mapper.getTradingCountById(user_id);
		return count;
	}
	
	// insert - Trading 매수
	public boolean buyTrading(Trading trading) throws SQLException, Exception {
		boolean result = false;
		int investorMoney = mapper.getInvestorMoneyByUserId(trading.getUser_id());
		if(investorMoney >= trading.getTrading_price()) {
			int money = investorMoney - trading.getTrading_price();
		
			int res = mapper.insertTrading(trading);
			int res2 = mapper.updateInvestorMoneyByUserId(money, trading.getUser_id());
		
			if(res != 0 && res2 != 0) {
				result = true;
			} else {
				throw new Exception("해당종목 매수 실패");
			}
		} else {
			throw new Exception("금액 부족");
		}
		return result;
	}
	
	
	// insert - Trading 매도
	public boolean sellTrading(Trading trading) throws SQLException, Exception {
		boolean result = false;
		
		int buy_volume;
		try {
			buy_volume = mapper.getTradingVolumeByCodeAndIdAndStatus(trading.getStocks_code(),trading.getUser_id(),"buy");
		} catch (NullPointerException e) {
			buy_volume = 0;
		}
		
		int sell_volume;
		try {
			sell_volume = mapper.getTradingVolumeByCodeAndIdAndStatus(trading.getStocks_code(),trading.getUser_id(),"sell");
		} catch (NullPointerException e) {
			sell_volume = 0;
		}
		
		int total_volume = buy_volume - sell_volume;
		
		if(total_volume >= trading.getVolume()) {
			int money = mapper.getInvestorMoneyByUserId(trading.getUser_id()) + trading.getTrading_price();
		
			int res = mapper.insertTrading(trading);
			int res2 = mapper.updateInvestorMoneyByUserId(money, trading.getUser_id());
		
			if(res != 0 && res2 != 0) {
				result = true;
			} else {
				throw new Exception("해당종목 매도 실패");
			}
		} else {
			throw new Exception("가진 주보다 많은 양을 팔 수 없습니다.");
		}
		return result;
	}

	// update- trading
	public boolean updateTrading(Trading trading) throws SQLException, Exception {
		boolean result = false;
		
		int res = mapper.updateTrading(trading);
		
		if(res != 0) {
			result = true;
		} else {
			throw new Exception("거래 실패");
		}
		
		return result;
	}
	
	// delete - trading
	public boolean deleteTrading(String stocks_code) throws SQLException, Exception {
		boolean result = false;
		
		int res = mapper.deleteTrading(stocks_code);
		
		if(res != 0) {
			result = true;
		} else {
			throw new Exception("매도 실패");
		}
		
		return result;
	}


}
