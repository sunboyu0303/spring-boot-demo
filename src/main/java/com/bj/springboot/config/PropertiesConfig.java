package com.bj.springboot.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by sunboyu on 2017/8/6.
 */
@Component
@Slf4j
public class PropertiesConfig {

    @Value("${com.jd.springboot.demo.title}")
    private String title;

    @Value("${com.jd.springboot.demo.description}")
    private String description;

    public void sys(){
        log.info("PropertiesConfig title value : {}, description value : {}", title, description);
    }
}
