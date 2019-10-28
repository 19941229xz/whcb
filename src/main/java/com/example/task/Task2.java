package com.example.task;


import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

//@EnableScheduling
//@Component
//@Configuration
@Slf4j
public class Task2 implements SchedulingConfigurer {


    @Mapper
    public interface CronDao{

        @Cacheable(value = "cron",key = "#p0")
        @Select("select cronExpression from cron where id = #{id}")
        public String getCronById(int id);

    }

    @Autowired
    CronDao cronDao;




    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {



        scheduledTaskRegistrar.addTriggerTask(
                () -> log.info("动态定时任务执行的时间：{}", LocalDateTime.now()),
                triggerContext -> {

                    String cron = cronDao.getCronById(1);

                    if(!StringUtils.isEmpty(cron)){
                        log.info("执行某某定时任务");
                    }

                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );



    }
}
