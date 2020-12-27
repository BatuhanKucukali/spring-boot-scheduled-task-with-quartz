package com.arch.tasks;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobConfig {

    @Bean
    public JobDetail helloJobDetail() {
        return JobBuilder
                .newJob(HelloJob.class)
                .withIdentity("HelloJob")
                .withDescription("HelloJob description detail.")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger helloJobTrigger(JobDetail helloJobDetail) {
        return TriggerBuilder.newTrigger()
                .forJob(helloJobDetail)
                .withIdentity("HelloJob")
                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever())
                .build();
    }

}
