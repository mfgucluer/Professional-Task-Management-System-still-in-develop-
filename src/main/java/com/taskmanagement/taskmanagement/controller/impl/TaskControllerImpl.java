package com.taskmanagement.taskmanagement.controller.impl;

import com.taskmanagement.taskmanagement.constants.ApiConstants;
import com.taskmanagement.taskmanagement.controller.TaskController;
import com.taskmanagement.taskmanagement.model.dto.response.TaskDto;
import com.taskmanagement.taskmanagement.model.dto.request.TaskInputDto;
import com.taskmanagement.taskmanagement.model.dto.response.TaskTitleDto;
import com.taskmanagement.taskmanagement.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiConstants.TASKS)
public class TaskControllerImpl implements TaskController {

    private final TaskService taskService;

    public TaskControllerImpl(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    @Override
    public ResponseEntity<TaskDto> createTask(@Valid @RequestBody TaskInputDto taskInputDto) {
        TaskDto task = taskService.saveTask(taskInputDto);
        return ResponseEntity.ok(task);
    }

    @GetMapping(ApiConstants.TASK_BY_USER_ID)
    @Override
    public ResponseEntity<List<TaskTitleDto>> getTasksByUserId(@PathVariable Long userId) {
        List<TaskTitleDto> tasks = taskService.getTasksOfUser(userId);
        return ResponseEntity.ok(tasks);
    }

    @GetMapping(ApiConstants.TASK_BY_ID)
    @Override
    public ResponseEntity<TaskDto> getTaskById(@PathVariable(name = "id") Long id) {
        TaskDto task = taskService.getTask(id);
        return ResponseEntity.ok(task);
    }

    @PutMapping(ApiConstants.TASK_BY_ID)
    @Override
    public ResponseEntity<String> updateTask(@PathVariable(name = "id") Long taskId, @Valid @RequestBody TaskInputDto updateTask) {
        String result = taskService.updateTask(taskId, updateTask);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(ApiConstants.TASK_BY_ID)
    @Override
    public ResponseEntity<Void> deleteTask(@PathVariable(name = "id") Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(ApiConstants.TASK_BY_USER_ID)
    @Override
    public ResponseEntity<Void> deleteAllTasksByUserId(@PathVariable Long userId) {
        taskService.deleteAllByUserId(userId);
        return ResponseEntity.ok().build();
    }
}
