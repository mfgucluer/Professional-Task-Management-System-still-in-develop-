package com.taskmanagement.taskmanagement.generator;

import com.taskmanagement.taskmanagement.domain.User;
import com.taskmanagement.taskmanagement.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class TaskNoGenerator {

    UserRepository userRepository;

    public TaskNoGenerator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public String generateTaskNo(Long userId) {
        // Kullanıcıyı veritabanından kilitleyerek getiriyor
        User user = userRepository.findUserForUpdate(userId);

        int currentCounter = user.getTaskCounter();
        int nextCounter = (currentCounter >= 9999) ? 1 : currentCounter + 1;
        user.setTaskCounter(nextCounter);

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmm"));
        String formattedCounter = String.format("%04d", nextCounter);
        String formattedUserId = String.format("%03d", userId);  // <-- Burada userId 3 haneli olacak
        String checkIndex = HashGenerator.generateHash(timestamp, userId, nextCounter);

        return timestamp + "-" + formattedUserId + "-" + checkIndex + "-" + formattedCounter;
    }

}
