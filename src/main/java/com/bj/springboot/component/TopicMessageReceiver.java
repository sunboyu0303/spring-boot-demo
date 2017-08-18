package com.bj.springboot.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by sunboyu on 2017/8/11.
 */
@Component
@RabbitListener(queues = "topic.message")
@Slf4j
public class TopicMessageReceiver {

    @RabbitHandler
    public void process(String message) {
        log.info("Topic Message : " + message);
    }
}
