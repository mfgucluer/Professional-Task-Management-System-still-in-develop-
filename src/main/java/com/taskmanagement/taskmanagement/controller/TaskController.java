package com.taskmanagement.taskmanagement.controller;

import com.taskmanagement.taskmanagement.model.dto.response.TaskDto;
import com.taskmanagement.taskmanagement.model.dto.request.TaskInputDto;
import com.taskmanagement.taskmanagement.model.dto.response.TaskTitleDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskController {
    ResponseEntity<TaskDto> createTask(TaskInputDto taskInputDto);

    ResponseEntity<List<TaskTitleDto>> getTasksByUserId(Long userId);

    ResponseEntity<TaskDto> getTaskById(Long id);

    ResponseEntity<String> updateTask(Long id, TaskInputDto updateTask);

    ResponseEntity<Void> deleteTask(Long id);

    ResponseEntity<Void> deleteAllTasksByUserId(Long userId);

    ResponseEntity<TaskDto> getTaskByTaskNo(String taskNo);
}
