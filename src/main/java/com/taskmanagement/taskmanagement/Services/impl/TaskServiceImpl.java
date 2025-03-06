package com.taskmanagement.taskmanagement.Services.impl;

import com.taskmanagement.taskmanagement.Domain.Task;
import com.taskmanagement.taskmanagement.Domain.User;
import com.taskmanagement.taskmanagement.Repository.TaskRepository;
import com.taskmanagement.taskmanagement.Repository.UserRepository;
import com.taskmanagement.taskmanagement.Response.DtoTask;
import com.taskmanagement.taskmanagement.Response.DtoTaskInUp;
import com.taskmanagement.taskmanagement.Response.DtoTaskTitle;
import com.taskmanagement.taskmanagement.Response.DtoUser;
import com.taskmanagement.taskmanagement.Services.TaskService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    TaskRepository taskRepository;
    UserRepository userRepository;

    public TaskServiceImpl(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Override
    public DtoTask saveTask(DtoTaskInUp dtoTaskInUp) {
        Optional<User> dbUser = userRepository.findById(dtoTaskInUp.getUserId());
        if(dbUser.isEmpty()) {
            return null;
        }
        User user = dbUser.get();

        Task task = new Task();
        task.setTitle(dtoTaskInUp.getTitle());
        task.setDescription(dtoTaskInUp.getDescription());
        task.setCompleted(dtoTaskInUp.getCompleted());
        task.setUser(user);
        taskRepository.save(task);

        DtoTask dtoTask = new DtoTask();
        dtoTask.setTitle(dtoTaskInUp.getTitle());
        dtoTask.setDescription(dtoTaskInUp.getDescription());
        dtoTask.setCompleted(dtoTaskInUp.getCompleted());

        DtoUser dtoUser = new DtoUser();
        dtoUser.setUsername(user.getUsername());

        dtoTask.setDtoUser(dtoUser);

        return dtoTask;
    }

    @Override
    public List<DtoTaskTitle> getTasksOfUser(Long userId) {
        List<Task> dbTaskList = taskRepository.findByUser_id(userId);
        List<DtoTaskTitle> taskList = new ArrayList<>();

        for (Task task : dbTaskList) {
            DtoTaskTitle dtoTaskTitle = new DtoTaskTitle();
            dtoTaskTitle.setTitle(task.getTitle());
            dtoTaskTitle.setCompleted(task.getCompleted());
            taskList.add(dtoTaskTitle);
        }
        return taskList;
    }

    @Override
    public DtoTask getTask(Long taskId) {
        Optional<Task> task = taskRepository.findById(taskId);
        if(task.isEmpty()) {
            return null;
        }
        Task t = task.get();

        DtoTask dtoTask = new DtoTask();
        dtoTask.setTitle(t.getTitle());
        dtoTask.setDescription(t.getDescription());
        dtoTask.setCompleted(t.getCompleted());


        Optional<User> dbUser = userRepository.findById(t.getUser().getId());
        if(dbUser.isEmpty()) {
            return null;
        }
        User user = dbUser.get();

        DtoUser dtoUser = new DtoUser();
        dtoUser.setUsername(user.getUsername());
        dtoTask.setDtoUser(dtoUser);

        return dtoTask;

    }
}