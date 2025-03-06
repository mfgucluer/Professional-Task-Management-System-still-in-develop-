package com.taskmanagement.taskmanagement.Controller.impl;

import com.taskmanagement.taskmanagement.Controller.TaskController;
import com.taskmanagement.taskmanagement.Response.DtoTask;
import com.taskmanagement.taskmanagement.Response.DtoTaskInUp;
import com.taskmanagement.taskmanagement.Response.DtoTaskTitle;
import com.taskmanagement.taskmanagement.Services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/rest/api/task")
public class TaskControllerImpl implements TaskController {

    TaskService taskService;

    public TaskControllerImpl(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/save")
    @Override
    public DtoTask saveTask(@RequestBody DtoTaskInUp dtoTaskInUp) {
        return taskService.saveTask(dtoTaskInUp);
    }

    @GetMapping("/list/{id}")
    @Override
    public List<DtoTaskTitle> getTasksOfUser(@PathVariable(name = "id") Long userId) {
        return taskService.getTasksOfUser(userId);
    }

    @GetMapping("/{id}")
    @Override
    public DtoTask getTask(@PathVariable(name = "id") Long taskId) {
        return taskService.getTask(taskId);
    }
}
