package com.demo.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.demo.mapping.scheduler.Test;
@Configuration
public class Configure {

	@Bean
	public Test test() {
		return new Test();
		
	}
	@Bean
	public RestTemplate template() {
		return new RestTemplate();
		
	}
}
