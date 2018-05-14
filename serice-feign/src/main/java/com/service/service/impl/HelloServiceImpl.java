package com.service.service.impl;
/*
 *一句话描述该类作用:【】
 *@Author:LB
 *
 */

import com.service.service.HelloService;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceImpl implements HelloService{


    @Override
    public String sayHiFromClientOne(String name) {
        return "error";
    }
}
