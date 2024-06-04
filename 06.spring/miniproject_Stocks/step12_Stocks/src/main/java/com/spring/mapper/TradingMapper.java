package com.spring.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.spring.dto.Investor;
import com.spring.dto.Stocks;
import com.spring.dto.Trading;

@Mapper
public interface TradingMapper {

	public Investor getInvestorByUserIdAndPassword(@Param("user_id") String user_id, @Param("password") String password) throws SQLException;
	
	public List<Stocks> getAllStocks();

	public Stocks getStocksByCode(String stocks_code);
  
	// List
	public List<Trading> getAllTrading();

	// 객체 - stock_code
	public int getTradingCountById(String user_id);
	
	// insert - stocks
	public int insertTrading(Trading trading) throws SQLException;
	
	// update - stocks
	public int updateTrading(Trading trading) throws SQLException;
	
	// delete - stocks_code
	public int deleteTrading(String stocks_code) throws SQLException;
	
	// investor 계좌금액 변경
	public int updateInvestorMoneyByUserId(@Param("user_money") int user_money, @Param("user_id") String user_id);

	// user별 investor 계좌금액 조회
	public int getInvestorMoneyByUserId(String user_id);

	public Integer getTradingVolumeByCodeAndIdAndStatus(@Param("stocks_code") String stocks_code, @Param("user_id") String user_id, @Param("status") String status) throws NullPointerException;

	public List<Trading> getTradingByStocks_code(String stocks_code);
}
