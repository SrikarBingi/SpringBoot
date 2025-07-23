package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class WebMvcConfig {
	
	@Bean
	public InternalResourceViewResolver initResolver() {
		
		InternalResourceViewResolver ir = new InternalResourceViewResolver();
		ir.setPrefix("/");
		ir.setSuffix(".html");
		
		return ir;
	}
	
}
