package com.serviceRibbon.app;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.serviceRibbon.controller" ,"com.serviceRibbon.service"})
@EnableHystrix
@EnableHystrixDashboard
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

	@Bean
	public ServletRegistrationBean getServlet(){
		HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
		registrationBean.setLoadOnStartup(1);
		registrationBean.addUrlMappings("/hystrix.stream");
		registrationBean.setName("HystrixMetricsStreamServlet");
		registrationBean.setName("HystrixMetricsStreamServlet");
		return registrationBean;

	}

}
