package com.taskmanagement.taskmanagement.Services;

import com.taskmanagement.taskmanagement.Response.DtoTask;
import com.taskmanagement.taskmanagement.Response.DtoTaskInUp;
import com.taskmanagement.taskmanagement.Response.DtoTaskTitle;

import java.util.List;


public interface TaskService {


    public DtoTask saveTask(DtoTaskInUp dtoTaskInUp); ///save task for user

    public List<DtoTaskTitle> getTasksOfUser(Long userId); ///view All task of user(This is just gonna return title and completed of tasks)

    public DtoTask getTask(Long taskId); ///view a task by taskId(This is gonna extract all task featurues include )

    public String updateTask(Long taskId, DtoTaskInUp updateTask); ///update a task of user

    public void deleteTask(Long taskId); ///delete task of user

    void deleteAllByUserId(Long userId);

}

