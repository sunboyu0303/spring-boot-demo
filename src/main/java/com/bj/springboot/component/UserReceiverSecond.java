package com.bj.springboot.component;

import com.bj.springboot.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by sunboyu on 2017/8/11.
 */
@Component
@RabbitListener(queues = "user")
@Slf4j
public class UserReceiverSecond {

    @RabbitHandler
    public void receiver(User u){
        log.info("UserReceiverSecond Receiver : " + u);
    }
}
