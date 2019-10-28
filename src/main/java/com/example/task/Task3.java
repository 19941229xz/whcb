package com.example.task;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

//@EnableScheduling
@Configuration
@Slf4j
@EnableAsync
public class Task3 {

    @Async
    @Scheduled(fixedRate = 2000)
    public void test1() throws InterruptedException {

        Thread.sleep(3000);
        log.info("我是test1，时间{}", LocalDateTime.now());
    }

//    @Async
//    @Scheduled(fixedRate = 1000)
//    public void test2(){
//        log.info("我是test2，时间{}", LocalDateTime.now());
//    }



}
