package com.spring.dto;

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

public class Trading {
	String trading_id;
    String stocks_code;  
    String user_id;      
    int volume; 
    int trading_price; 
    String status;
}
