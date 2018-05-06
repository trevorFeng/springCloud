package com.serviceRibbon.controller;

import com.serviceRibbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 *一句话描述该类作用:【】
 *@Author:LB
 *
 */
@RestController
public class HelloController {
    @Autowired
    HelloService helloService;
    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name){
        return helloService.hiService(name);
    }

}
