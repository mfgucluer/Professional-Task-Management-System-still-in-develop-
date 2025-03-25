package com.taskmanagement.taskmanagement.services.impl;

import com.taskmanagement.taskmanagement.domain.Task;
import com.taskmanagement.taskmanagement.domain.User;
import com.taskmanagement.taskmanagement.exception.BaseException;
import com.taskmanagement.taskmanagement.exception.ErrorMessage;
import com.taskmanagement.taskmanagement.exception.MessageType;
import com.taskmanagement.taskmanagement.generator.TaskNoGenerator;
import com.taskmanagement.taskmanagement.model.mapper.TaskMapper;
import com.taskmanagement.taskmanagement.repository.TaskRepository;
import com.taskmanagement.taskmanagement.repository.UserRepository;
import com.taskmanagement.taskmanagement.model.dto.response.TaskDto;
import com.taskmanagement.taskmanagement.model.dto.request.TaskInputDto;
import com.taskmanagement.taskmanagement.model.dto.response.TaskTitleDto;
import com.taskmanagement.taskmanagement.model.dto.response.UserDto;
import com.taskmanagement.taskmanagement.services.TaskService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

@Transactional(readOnly = true)
public class TaskServiceImpl implements TaskService {

    TaskRepository taskRepository;
    UserRepository userRepository;
    TaskNoGenerator taskNoGenerator;

    public TaskServiceImpl(TaskRepository taskRepository, UserRepository userRepository, TaskNoGenerator taskNoGenerator) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.taskNoGenerator = taskNoGenerator;
    }

    @Transactional(readOnly = false)
    @Override
    public TaskDto saveTask(TaskInputDto taskInputDto) {
        Optional<User> dbUser = userRepository.findById(taskInputDto.getUserId());
        if(dbUser.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, taskInputDto.getUserId().toString()+" id user not created"));
        }
        User user = dbUser.get();

        Task task = TaskMapper.INSTANCE.taskInputDtoToTask(taskInputDto);
        task.setUser(user);
        task.setTaskNo(taskNoGenerator.generateTaskNo(taskInputDto.getUserId()));
        taskRepository.save(task);

        TaskDto taskDto = TaskMapper.INSTANCE.taskInputDtoToTaskDto(taskInputDto);

        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());

        taskDto.setUserDto(userDto);

        return taskDto;
    }

    @Transactional
    @Override
    public List<TaskTitleDto> getTasksOfUser(Long userId) {
        Optional<User> user =  userRepository.findById(userId);
        if(user.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, userId.toString()+" id user not found"));
        }
        List<Task> dbTaskList = taskRepository.findByUser_id(userId);
        if(dbTaskList.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, "Kullanicinin task'i yok."));
        }

        List<TaskTitleDto> taskList = new ArrayList<>();

        for (Task task : dbTaskList) {
            TaskTitleDto taskTitleDto = new TaskTitleDto();
            taskTitleDto.setTitle(task.getTitle());
            taskTitleDto.setCompleted(task.getCompleted());
            taskList.add(taskTitleDto);
        }
        return taskList;
    }

    @Transactional
    @Override
    public TaskDto getTask(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if(optionalTask.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString()+" id task not found"));
        }
        Task task = optionalTask.get();

        TaskDto taskDto = new TaskDto();
        taskDto.setTitle(task.getTitle());
        taskDto.setDescription(task.getDescription());
        taskDto.setCompleted(task.getCompleted());

//        TaskDto taskDto = TaskMapper.INSTANCE.taskToTaskDto(task);

        Optional<User> dbUser = userRepository.findById(task.getUser().getId());
        if(dbUser.isEmpty()) {
            return null;
        }
        User user = dbUser.get();

        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        taskDto.setUserDto(userDto);

        return taskDto;

    }

    @Transactional(readOnly = false)
    @Override
    public String updateTask(Long taskId, TaskInputDto updateTask) {
        Optional<Task> dbTask = taskRepository.findById(taskId);
        if(dbTask.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, taskId.toString()+" id task not found"));
        }

        String response = new String();

        Task task = dbTask.get();
        TaskDto taskDto = new TaskDto();

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

    @Transactional(readOnly = false)
    @Override
    public void deleteTask(Long taskId) {
        Optional<Task> task = taskRepository.findById(taskId);
        if(task.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, taskId.toString()+" id task not found"));
        }
        taskRepository.deleteById(taskId);
    }

    @Transactional(readOnly = false)
    @Override
    public void deleteAllByUserId(Long userId) {
        Optional<User> user =  userRepository.findById(userId);
        if(user.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, userId.toString()+" id user not found"));
        }
        taskRepository.deleteAllByUserId(userId);
    }

}