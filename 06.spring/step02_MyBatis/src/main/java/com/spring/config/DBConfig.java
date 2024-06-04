package com.spring.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBConfig {
	
	@Bean
	// public static SQLSesstionFactory getsqlSessionFactory() 
	public static SqlSessionFactory getsqlSessionFactory(){
		
		// step01 : mybatis-config.xml 읽어서 Factory 생성
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder;
		SqlSessionFactory sqlSessionFactory = null;
		
		String resource = "/mybatis-config.xml";
		InputStream is = null;
		try {
			 is = Resources.getResourceAsStream(resource);
			 sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			 sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
			 
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sqlSessionFactory;
		
	}
	
	@Bean
	// public static SqlSession getSqlSession()
	public static SqlSession getSqlSession() {
		SqlSession sqlSession = null;
		
		SqlSessionFactory sqlSessionFactory = getsqlSessionFactory();
		
		if(sqlSessionFactory != null) {
			sqlSession = sqlSessionFactory.openSession();
		}
		
		return sqlSession;
	}

}
