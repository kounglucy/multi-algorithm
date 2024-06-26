package com.spring.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.spring.interceptor.SessionInterceptor;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
	
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
 
        return viewResolver;
    }
	
    @Override 
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/").setCachePeriod(60 * 60 * 24 * 365); 
    }
    
    
	// 	default void addInterceptors(InterceptorRegistry registry)
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	registry.addInterceptor(new SessionInterceptor())
			        .addPathPatterns("/dept***")
			        .addPathPatterns("/dept/***")
			        .addPathPatterns("/logout")
			        .excludePathPatterns("/main")
			        .excludePathPatterns("/login");
    }
    
    
    @Bean
	public FilterRegistrationBean httpMethodFilter() {
		FilterRegistrationBean filter = new FilterRegistrationBean();
		filter.setFilter(new HiddenHttpMethodFilter());
		filter.setName("httpMethodFilter");
		filter.addUrlPatterns("/*");
		return filter;
	}
    
}