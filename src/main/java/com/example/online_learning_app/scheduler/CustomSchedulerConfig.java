package com.example.online_learning_app.scheduler;

import com.example.online_learning_app.repository.AssignmentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
public class CustomSchedulerConfig {
    private final AssignmentsRepository assignmentsRepository;


/*todo
   second
   minute
   hour
   day of month
   month
   day of week
   */
    @Scheduled(cron = "*/3 * * * * *")
    public Date date() {
        System.out.println(assignmentsRepository.findAll());
        System.out.println(new Date());
        return new Date();
    }
}
