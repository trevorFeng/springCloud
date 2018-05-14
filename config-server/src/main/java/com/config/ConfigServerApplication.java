package com.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Author LB
 * @Description 【在分布式系统中，由于服务数量巨多，为了方便服务配置文件统一管理，实时更新，所以需要分布式配置中心组件。
				 * 在Spring Cloud中，有分布式配置中心组件spring cloud config ，它支持配置服务放在配置服务的内存中（即本地），
				 * 也支持放在远程Git仓库中。
				 * 在spring cloud config 组件中，分两个角色，一是config server，二是config client
 					* 配置中心如何从远程git读取配置文件
				 * @EnableConfigServer注解开启配置服务器的功能】
 * @Param
 *
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}
}
