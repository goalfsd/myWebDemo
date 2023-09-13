package com.lucianlu.mywebdemo.controller;

import javax.annotation.Resource;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Resource
    ApplicationContext applicationContext;

    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }

    @RequestMapping("/username")
    public String username() {
        return applicationContext.getEnvironment().getProperty("custom-config.username");
    }
}
