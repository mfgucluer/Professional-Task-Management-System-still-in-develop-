package com.taskmanagement.taskmanagement.Services.impl;

import com.taskmanagement.taskmanagement.Domain.Task;
import com.taskmanagement.taskmanagement.Domain.User;
import com.taskmanagement.taskmanagement.Exception.BaseException;
import com.taskmanagement.taskmanagement.Exception.ErrorMessage;
import com.taskmanagement.taskmanagement.Exception.MessageType;
import com.taskmanagement.taskmanagement.Repository.TaskRepository;
import com.taskmanagement.taskmanagement.Repository.UserRepository;
import com.taskmanagement.taskmanagement.Response.DtoTask;
import com.taskmanagement.taskmanagement.Response.DtoTaskInUp;
import com.taskmanagement.taskmanagement.Response.DtoTaskTitle;
import com.taskmanagement.taskmanagement.Response.DtoUser;
import com.taskmanagement.taskmanagement.Services.TaskService;
import jakarta.transaction.Transactional;
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

    @Transactional
    @Override
    public DtoTask saveTask(DtoTaskInUp dtoTaskInUp) {
        Optional<User> dbUser = userRepository.findById(dtoTaskInUp.getUserId());
        if(dbUser.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoTaskInUp.getUserId().toString()+" id user not created"));

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

    @Transactional
    @Override
    public List<DtoTaskTitle> getTasksOfUser(Long userId) {
        Optional<User> user =  userRepository.findById(userId);
        if(user.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, userId.toString()+" id user not found"));
        }
        List<Task> dbTaskList = taskRepository.findByUser_id(userId);
        if(dbTaskList.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, "Kullanicinin task'i yok."));
        }

        List<DtoTaskTitle> taskList = new ArrayList<>();

        for (Task task : dbTaskList) {
            DtoTaskTitle dtoTaskTitle = new DtoTaskTitle();
            dtoTaskTitle.setTitle(task.getTitle());
            dtoTaskTitle.setCompleted(task.getCompleted());
            taskList.add(dtoTaskTitle);
        }
        return taskList;
    }

    @Transactional
    @Override
    public DtoTask getTask(Long taskId) {
        Optional<Task> task = taskRepository.findById(taskId);
        if(task.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, taskId.toString()+" id task not found"));
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

    @Transactional
    @Override
    public String updateTask(Long taskId, DtoTaskInUp updateTask) {
        Optional<Task> dbTask = taskRepository.findById(taskId);
        if(dbTask.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, taskId.toString()+" id task not found"));
        }

        String response = new String();

        Task task = dbTask.get();
        DtoTask dtoTask = new DtoTask();

            if (updateTask.getTitle() != null) {
                task.setTitle(updateTask.getTitle());
                response = "Başarılı";
            }

            if (updateTask.getDescription() != null) {
                task.setDescription(updateTask.getDescription());
                response = "Başarılı";
            }

            if (updateTask.getCompleted() != null) {
                task.setCompleted(updateTask.getCompleted());
                response = "Başarılı";
            }

        return response;
    }

    @Override
    public void deleteTask(Long taskId) {
        Optional<Task> task = taskRepository.findById(taskId);
        if(task.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, taskId.toString()+" id task not found"));
        }
        taskRepository.deleteById(taskId);
    }

    @Override
    public void deleteAllByUserId(Long userId) {
        Optional<User> user =  userRepository.findById(userId);
        if(user.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, userId.toString()+" id user not found"));
        }
        taskRepository.deleteAllByUserId(userId);
    }

}