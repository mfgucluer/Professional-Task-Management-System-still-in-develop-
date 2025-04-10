package com.taskmanagement.taskmanagement.generator;

import com.taskmanagement.taskmanagement.domain.TaskCounter;
import com.taskmanagement.taskmanagement.repository.TaskCounterRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class TaskNoGenerator {

    private final TaskCounterRepository taskCounterRepository;

    public TaskNoGenerator(TaskCounterRepository taskCounterRepository) {
        this.taskCounterRepository = taskCounterRepository;
    }

    @Transactional
    public String generateTaskNo(Long userId) {
        // Get global counter with pessimistic lock
        TaskCounter counter = taskCounterRepository.findGlobalCounterForUpdate();
        
        // If counter doesn't exist yet, create it
        if (counter == null) {
            counter = new TaskCounter();
            counter.setCounterValue(0);
            counter.setCounterName("GLOBAL_COUNTER");
            taskCounterRepository.save(counter);
        }

        int currentCounter = counter.getCounterValue();
        int nextCounter = (currentCounter >= 9999) ? 1 : currentCounter + 1;
        counter.setCounterValue(nextCounter);
        taskCounterRepository.save(counter);

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmm"));
        String formattedCounter = String.format("%04d", nextCounter);
        String formattedUserId = String.format("%03d", userId);
        String checkIndex = HashGenerator.generateHash(timestamp, userId, nextCounter);

        return timestamp + "-" + formattedUserId + "-" + checkIndex + "-" + formattedCounter;
    }

}
