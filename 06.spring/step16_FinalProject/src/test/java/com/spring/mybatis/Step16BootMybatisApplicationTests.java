package com.spring.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.dto.Review;

@SpringBootTest
class Step16BootMybatisApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	Review dept;
	
	@Test
	public void valueTest() {
		System.out.println(dept.toString());
	}

}
