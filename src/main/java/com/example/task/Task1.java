package com.example.task;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

//@Component
//@EnableScheduling
//@Configuration
@Slf4j
public class Task1 {



//    @Scheduled(cron = "5 * * * * ?")
    @Scheduled(fixedRate = 5000)
    public void test1(){

        log.info("执行静态定时任务的时间{}", LocalDateTime.now());

    }



}
