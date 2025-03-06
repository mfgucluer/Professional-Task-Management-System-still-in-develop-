package com.taskmanagement.taskmanagement.Controller;

import com.taskmanagement.taskmanagement.Response.DtoTask;
import com.taskmanagement.taskmanagement.Response.DtoTaskInUp;
import com.taskmanagement.taskmanagement.Response.DtoTaskTitle;

import java.util.List;

public interface TaskController {

    public DtoTask saveTask(DtoTaskInUp dtoTaskInUp);

    public List<DtoTaskTitle> getTasksOfUser(Long userId);

    public DtoTask getTask(Long taskId);

}
