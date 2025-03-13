package com.taskmanagement.taskmanagement.Controller.impl;

import com.taskmanagement.taskmanagement.Constants.ApiConstants;
import com.taskmanagement.taskmanagement.Controller.TaskController;
import com.taskmanagement.taskmanagement.Response.DtoTask;
import com.taskmanagement.taskmanagement.Response.DtoTaskInUp;
import com.taskmanagement.taskmanagement.Response.DtoTaskTitle;
import com.taskmanagement.taskmanagement.Services.TaskService;
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
    public ResponseEntity<DtoTask> createTask(@Valid @RequestBody DtoTaskInUp dtoTaskInUp) {
        DtoTask task = taskService.saveTask(dtoTaskInUp);
        return ResponseEntity.ok(task);
    }

    @GetMapping(ApiConstants.TASK_BY_USER_ID)
    @Override
    public ResponseEntity<List<DtoTaskTitle>> getTasksByUserId(@PathVariable Long userId) {
        List<DtoTaskTitle> tasks = taskService.getTasksOfUser(userId);
        return ResponseEntity.ok(tasks);
    }

    @GetMapping(ApiConstants.TASK_BY_ID)
    @Override
    public ResponseEntity<DtoTask> getTaskById(@PathVariable(name = "id") Long taskId) {
        DtoTask task = taskService.getTask(taskId);
        return ResponseEntity.ok(task);
    }

    @PutMapping(ApiConstants.TASK_BY_ID)
    @Override
    public ResponseEntity<String> updateTask(@PathVariable(name = "id") Long taskId, @Valid @RequestBody DtoTaskInUp updateTask) {
        String result = taskService.updateTask(taskId, updateTask);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(ApiConstants.TASK_BY_ID)
    @Override
    public ResponseEntity<Void> deleteTask(@PathVariable(name = "id") Long taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(ApiConstants.TASK_BY_USER_ID)
    @Override
    public ResponseEntity<Void> deleteAllTasksByUserId(@PathVariable Long userId) {
        taskService.deleteAllByUserId(userId);
        return ResponseEntity.ok().build();
    }
}
