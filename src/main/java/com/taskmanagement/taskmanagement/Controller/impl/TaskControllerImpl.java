package com.taskmanagement.taskmanagement.Controller.impl;

import com.taskmanagement.taskmanagement.Controller.TaskController;
import com.taskmanagement.taskmanagement.Response.DtoTask;
import com.taskmanagement.taskmanagement.Response.DtoTaskInUp;
import com.taskmanagement.taskmanagement.Response.DtoTaskTitle;
import com.taskmanagement.taskmanagement.Response.GenericResponse;
import com.taskmanagement.taskmanagement.Services.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskControllerImpl implements TaskController {

    private final TaskService taskService;

    public TaskControllerImpl(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    @Override
    public ResponseEntity<GenericResponse<DtoTask>> createTask(@Valid @RequestBody DtoTaskInUp dtoTaskInUp) {
        DtoTask task = taskService.saveTask(dtoTaskInUp);
        return ResponseEntity.ok(new GenericResponse<>(true, "Görev başarıyla oluşturuldu", task));
    }

    @GetMapping("/user/{userId}")
    @Override
    public ResponseEntity<GenericResponse<List<DtoTaskTitle>>> getTasksByUserId(@PathVariable Long userId) {
        List<DtoTaskTitle> tasks = taskService.getTasksOfUser(userId);
        return ResponseEntity.ok(new GenericResponse<>(true, "Görevler başarıyla getirildi", tasks));
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<GenericResponse<DtoTask>> getTaskById(@PathVariable(name = "id") Long taskId) {
        DtoTask task = taskService.getTask(taskId);
        return ResponseEntity.ok(new GenericResponse<>(true, "Görev başarıyla getirildi", task));
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<GenericResponse<String>> updateTask(@PathVariable(name = "id") Long taskId, @Valid @RequestBody DtoTaskInUp updateTask) {
        String result = taskService.updateTask(taskId, updateTask);
        return ResponseEntity.ok(new GenericResponse<>(true, "Görev başarıyla güncellendi", result));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<GenericResponse<Void>> deleteTask(@PathVariable(name = "id") Long taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.ok(new GenericResponse<>(true, "Görev başarıyla silindi", null));
    }

    @DeleteMapping("/user/{userId}")
    @Override
    public ResponseEntity<GenericResponse<Void>> deleteAllTasksByUserId(@PathVariable Long userId) {
        taskService.deleteAllByUserId(userId);
        return ResponseEntity.ok(new GenericResponse<>(true, "Kullanıcının tüm görevleri başarıyla silindi", null));
    }
}
