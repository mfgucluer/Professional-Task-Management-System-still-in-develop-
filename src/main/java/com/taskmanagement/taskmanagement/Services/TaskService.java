package com.taskmanagement.taskmanagement.Services;

import com.taskmanagement.taskmanagement.Response.DtoTask;
import com.taskmanagement.taskmanagement.Response.DtoTaskInUp;
import com.taskmanagement.taskmanagement.Response.DtoUserInUp;

public interface TaskService {

    public DtoTask saveTask(DtoTaskInUp dtoTaskInUp);


}
