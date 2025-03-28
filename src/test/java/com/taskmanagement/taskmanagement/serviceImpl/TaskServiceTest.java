package com.taskmanagement.taskmanagement.serviceImpl;


import com.taskmanagement.taskmanagement.domain.User;
import com.taskmanagement.taskmanagement.model.dto.request.TaskInputDto;
import com.taskmanagement.taskmanagement.repository.TaskRepository;
import com.taskmanagement.taskmanagement.repository.UserRepository;
import com.taskmanagement.taskmanagement.services.TaskService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock
    UserRepository userRepository;

    @Mock
    TaskRepository taskRepository;

    @InjectMocks
    TaskService taskService;


    @Test
    @DisplayName("saveTask - valid input - should return taskDto")
    void saveTask_validInput_shouldReturnTaskDto(){
        TaskInputDto taskInputDto = new TaskInputDto("Title 1", "Description 1", 1L, true);
        User user = new User();
        user.setId(1L);
        user.setUsername("john_doe");
        user.setPassword("securePassword");
        user.setEmail("john@example.com");






    }





}
