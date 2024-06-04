package com.spring.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Stocks {
	private String stocks_code;
	private int price;
	private String company_name;
	private int asset;
	private int debt;
    private int sales;
    private Date stocksdate;
}