package com.taskmanagement.taskmanagement.config;

import com.taskmanagement.taskmanagement.domain.TaskCounter;
import com.taskmanagement.taskmanagement.repository.TaskCounterRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(TaskCounterRepository taskCounterRepository) {
        return args -> {
            // Check if global counter exists
            TaskCounter counter = taskCounterRepository.findByCounterName("GLOBAL_COUNTER");
            
            // If not, create it
            if (counter == null) {
                counter = new TaskCounter();
                counter.setCounterValue(0);
                counter.setCounterName("GLOBAL_COUNTER");
                taskCounterRepository.save(counter);
                System.out.println("Global task counter initialized.");
            }
        };
    }
} 