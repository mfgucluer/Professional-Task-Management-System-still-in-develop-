package com.taskmanagement.taskmanagement.Controller;

import com.taskmanagement.taskmanagement.Response.DtoTask;
import com.taskmanagement.taskmanagement.Response.DtoTaskInUp;
import com.taskmanagement.taskmanagement.Response.DtoTaskTitle;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskController {
    ResponseEntity<DtoTask> createTask(DtoTaskInUp dtoTaskInUp);

    ResponseEntity<List<DtoTaskTitle>> getTasksByUserId(Long userId);

    ResponseEntity<DtoTask> getTaskById(Long taskId);

    ResponseEntity<String> updateTask(Long taskId, DtoTaskInUp updateTask);

    ResponseEntity<Void> deleteTask(Long taskId);

    ResponseEntity<Void> deleteAllTasksByUserId(Long userId);
}
