package com.bj.springboot.controller;

import com.bj.springboot.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

/**
 * Created by sunboyu on 2017/8/11.
 */
@RestController
@RequestMapping("/rabbit")
@Slf4j
public class RabbitController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping("/send")
    public void send(){
        String context = "hello " + new Date();
        log.info("Sender : " + context);
        amqpTemplate.convertAndSend("hello", context);
    }

    @RequestMapping("/sendUser")
    public void sendUser(){

        for(int i=0;i<100;i++){
            User u = new User();
            u.setId((long)i);
            u.setUsername("userName"+i);
            u.setPassword(UUID.randomUUID().toString());
            amqpTemplate.convertAndSend("user", u);
        }
    }

    @RequestMapping("/topicSend1")
    public void topicSend1(){
        String context = "hi, i am message 1";
        log.info("topicSend1 Sender : " + context);
        amqpTemplate.convertAndSend("exchange", "topic.message", context);
    }

    @RequestMapping("/topicSend2")
    public void topicSend2(){
        String context = "hi, i am message 2";
        log.info("topicSend2 Sender : " + context);
        amqpTemplate.convertAndSend("exchange", "topic.messages", context);
    }
}
