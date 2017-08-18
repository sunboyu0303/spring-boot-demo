package com.bj.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sunboyu on 2017/8/10.
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate template;

    @RequestMapping("/{key}/{value}")
    public String putStr(@PathVariable String key, @PathVariable String value){

        template.opsForValue().set(key, value);
        return template.opsForValue().get(key);
    }
}
