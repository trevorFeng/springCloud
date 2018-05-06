package com.serviceRibbon.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.serviceRibbon.controller" ,"com.serviceRibbon.service"})
public class ServiceRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRibbonApplication.class, args);

	}

	/**
	 * @Author LB
	 * @Description 【向程序的ioc注入一个bean: restTemplate;
	 * 				并通过@LoadBalanced注解表明这个restRemplate开启负载均衡的功能。】
	 * @Param
	 *
	 */
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
	    System.out.println("11111111111111111111111111111111111");
		return new RestTemplate();
	}

}
