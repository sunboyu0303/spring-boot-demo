package com.bj.springboot.component.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sunboyu on 2017/8/13.
 */
@Component
@Slf4j
public class Scheduler2Task {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     *
     * @Scheduled 参数可以接受两种定时的设置，
     * 一种是 cron=" * /6 * * * * ?" ,
     * 一种是 fixedRate = 6000，两种都表示每隔六秒打印一下内容。
     *
     * @Scheduled(fixedRate = 6000) ：上一次开始执行时间点之后6秒再执行；
     * @Scheduled(fixedDelay = 6000) ：上一次执行完毕时间点之后6秒再执行；
     * @Scheduled(initialDelay=1000, fixedRate=6000) ：第一次延迟1秒后执行，之后按fixedRate的规则每6秒执行一次。
     *
     */
    @Scheduled(fixedRate = 6000 * 1000)
    public void reportCurrentTime() {
        log.info("现在时间：" + simpleDateFormat.format(new Date()));
    }
}
