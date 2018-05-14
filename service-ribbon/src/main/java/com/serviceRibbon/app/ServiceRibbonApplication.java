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

/**
 * @Author LB
 * @Description 【@EnableHystrix开启熔断器功能，@EnableHystrixDashboard开启监控熔断器监控状态】
 * @Param
 *
 */
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
	 * 				并通过@LoadBalanced注解表明这个restRemplate开启负载均衡的功能。负载均衡的核心类为LoadBalancerClient】
	 * @Param
	 *
	 */
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	//http://localhost:8765/hystrix.stream
	//http://localhost:8765/hystrix
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
