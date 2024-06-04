package com.spring.configuration;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.spring.*"})
@MapperScan(basePackages = {"com.spring.mapper"})
public class RootConfig {
	static String resource = "/mybatis-config.xml";
	
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
