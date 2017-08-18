package com.bj.springboot.component.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by sunboyu on 2017/8/13.
 */
@Component
@Slf4j
public class SchedulerTask {

    private int count = 0;

    @Scheduled(cron = "0 0/30 * * * ?")
    private void process() {
        log.info("this is scheduler task runing  "+(count++));
    }
}