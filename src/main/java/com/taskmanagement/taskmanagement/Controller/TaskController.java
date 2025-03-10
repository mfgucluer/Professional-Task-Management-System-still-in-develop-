package com.taskmanagement.taskmanagement.Controller;

import com.taskmanagement.taskmanagement.Response.DtoTask;
import com.taskmanagement.taskmanagement.Response.DtoTaskInUp;
import com.taskmanagement.taskmanagement.Response.DtoTaskTitle;
import com.taskmanagement.taskmanagement.Response.GenericResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskController {
    ResponseEntity<GenericResponse<DtoTask>> createTask(DtoTaskInUp dtoTaskInUp);

    ResponseEntity<GenericResponse<List<DtoTaskTitle>>> getTasksByUserId(Long userId);

    ResponseEntity<GenericResponse<DtoTask>> getTaskById(Long taskId);

    ResponseEntity<GenericResponse<String>> updateTask(Long taskId, DtoTaskInUp updateTask);

    ResponseEntity<GenericResponse<Void>> deleteTask(Long taskId);

    ResponseEntity<GenericResponse<Void>> deleteAllTasksByUserId(Long userId);
}
