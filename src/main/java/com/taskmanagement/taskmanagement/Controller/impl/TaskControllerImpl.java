package com.taskmanagement.taskmanagement.Controller.impl;

import com.taskmanagement.taskmanagement.Controller.TaskController;
import com.taskmanagement.taskmanagement.Response.DtoTask;
import com.taskmanagement.taskmanagement.Response.DtoTaskInUp;
import com.taskmanagement.taskmanagement.Services.TaskService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
