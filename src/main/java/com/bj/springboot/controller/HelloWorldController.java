package com.bj.springboot.controller;

import com.bj.springboot.config.PropertiesConfig;
import com.bj.springboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sunboyu on 2017/8/5.
 */
@RestController
public class HelloWorldController {

    @Autowired
    private PropertiesConfig pc;

    @RequestMapping("/hello")
    public String index(){
        return "Hello World";
    }

    @RequestMapping("/getUser")
    public User getUser(){
        pc.sys();
        User u = new User();
        u.setUsername("zhangsan");
        u.setPassword("aurnfh!9dsmz");
        return u;
    }
}
