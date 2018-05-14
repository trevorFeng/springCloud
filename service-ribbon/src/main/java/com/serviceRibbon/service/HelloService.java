package com.serviceRibbon.service;
/*
 *一句话描述该类作用:【】
 *@Author:LB
 *
 */

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

/**
 * @Author LB
 * @Description 【@HystrixCommand表示若hiService()方法访问出错，则调用hiError()方法】
 * @Param
 *
 */
@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(@RequestParam(required = false,defaultValue = "liubing") String name) {
        return restTemplate.getForObject("http://SERVICE-1/hi?name="+name,String.class);
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }


}
