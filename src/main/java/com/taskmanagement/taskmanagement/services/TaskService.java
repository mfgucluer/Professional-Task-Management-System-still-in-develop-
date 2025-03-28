package com.taskmanagement.taskmanagement.services;

import com.taskmanagement.taskmanagement.model.dto.response.TaskDto;
import com.taskmanagement.taskmanagement.model.dto.request.TaskInputDto;
import com.taskmanagement.taskmanagement.model.dto.response.TaskTitleDto;

import java.util.List;


public interface TaskService {

    public TaskDto saveTask(TaskInputDto taskInputDto); ///save task for user

    public List<TaskTitleDto> getTasksOfUser(Long userId); ///view All task of user(This is just gonna return title and completed of tasks)

    public TaskDto getTask(Long id); ///view a task by taskId(This is gonna extract all task featurues include )

    public String updateTask(Long taskId, TaskInputDto updateTask); ///update a task of user

    public void deleteTask(Long taskId); ///delete task of user

    void deleteAllByUserId(Long userId);

    TaskDto getTaskByTaskNo(String taskNo);

}