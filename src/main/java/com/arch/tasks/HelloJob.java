package com.arch.tasks;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@DisallowConcurrentExecution
@AllArgsConstructor
public class HelloJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        log.info("Task started with Instance ID : {}", jobExecutionContext.getFireInstanceId());
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            //
        }
    }
}
