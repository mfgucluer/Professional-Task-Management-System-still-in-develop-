package com.taskmanagement.taskmanagement.Controller;

import com.taskmanagement.taskmanagement.Response.DtoTask;
import com.taskmanagement.taskmanagement.Response.DtoTaskInUp;

public interface TaskController {

    public DtoTask saveTask(DtoTaskInUp dtoTaskInUp);

}
