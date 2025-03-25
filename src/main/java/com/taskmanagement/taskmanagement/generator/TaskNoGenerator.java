package com.taskmanagement.taskmanagement.generator;

import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class TaskNoGenerator {

    private static final AtomicInteger COUNTER = new AtomicInteger(1); // 4 haneli numaratör başlangıcı

    public String generateTaskNo(Long userId) {

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmm"));

        int counter = COUNTER.getAndUpdate(value -> (value == 9999) ? 1 : value + 1);
        String formattedCounter = String.format("%04d", counter); // 4 haneli formatlama


        String checkIndex = HashGenerator.generateHash(timestamp, userId, counter);

        return timestamp + "-" + userId + "-" + checkIndex + "-" + formattedCounter;
    }

}
