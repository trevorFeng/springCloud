package com.serviceRibbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 *一句话描述该类作用:【】
 *@Author:LB
 *
 */
@RestController
public class RibbonController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/testRibbon")
    public String testRibbon(){
        /**
         * @Author LB
         * @Description 【choose()方法的参数为服务名,访问此接口轮流显示service-1的服务】
         * @Param
         *
         */
        ServiceInstance serviceInstance = loadBalancerClient.choose("service-1");
        return serviceInstance.getHost()+":"+serviceInstance.getPort();
    }
}
