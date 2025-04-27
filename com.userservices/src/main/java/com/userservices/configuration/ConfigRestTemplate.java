package com.userservices.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigRestTemplate {
	
	@Bean
	@LoadBalanced //for change and use servicename
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
