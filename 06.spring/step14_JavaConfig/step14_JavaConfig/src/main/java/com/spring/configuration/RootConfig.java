package com.spring.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.spring.*"})
@MapperScan(basePackages = {"com.spring.mapper"})
public class RootConfig {

}
