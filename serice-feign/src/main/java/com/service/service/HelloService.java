package com.service.service;

import com.service.config.FeignConfig;
import com.service.service.impl.HelloServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/*
 *一句话描述该类作用:【FeignConfig为配置类，调用失败会重试,fallback是服务降级后的接口实现类，若服务调用失败，则执行实现类方法】
 *@Author:LB
 *
 */
@FeignClient(value = "SERVICE-1" ,configuration = FeignConfig.class,fallback = HelloServiceImpl.class)
public interface HelloService {
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

}
