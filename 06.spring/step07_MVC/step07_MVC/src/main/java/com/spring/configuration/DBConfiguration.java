package com.spring.configuration;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBConfiguration {
	
	static String resource = "/mybatis-config.xml";
	
	// SqlSession을 생성하려면 Mybatis에서는 팩토리 패턴이라는 것을 사용해서 객체를 만듭니다.
	// 팩토리 패턴이라는 것은 바로 생성하는게 아니라 특정 객체를 셍성하기 위한 팩토리를 먼저 만들고,
	// 그 뒤에 해당 특정 객체를 생성하는 방법
	
	@Bean
	public static SqlSessionFactory getSqlSessionFactory() {
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder;
		SqlSessionFactory sqlSEssionFactory = null;
		

		InputStream is = null;
		try {
			is = Resources.getResourceAsStream(resource);
			sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			sqlSEssionFactory = sqlSessionFactoryBuilder.build(is);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return sqlSEssionFactory;
	}
	
	
	@Bean
	public static SqlSession getSqlSession() {
		SqlSession sqlSession = null;
		sqlSession = getSqlSessionFactory().openSession();
		return sqlSession;
	}
}
