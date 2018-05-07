package com.service.service;

import com.service.service.impl.HelloServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/*
 *一句话描述该类作用:【】
 *@Author:LB
 *
 */
@FeignClient(value = "service-1" ,fallback = HelloServiceImpl.class)
public interface HelloService {
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

}
