package com.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;



@SpringBootApplication
@EntityScan("com.*")
@EnableFeignClients
@EnableEurekaClient
public class MicroUserServiceApplication {
	
	/*
	 * @Bean
	 * 
	 * @LoadBalanced public RestTemplate restTemplate() { return new RestTemplate();
	 * }
	 */
	
	/*
	 * @Bean public WebClient webClient() { return WebClient.builder().build(); }
	 */
	 @Bean
	    @LoadBalanced
	    public WebClient.Builder loadBalancedWebClientBuilder() {
	     return WebClient.builder();
	    }

	public static void main(String[] args) {
		SpringApplication.run(MicroUserServiceApplication.class, args);
	}
}
	
