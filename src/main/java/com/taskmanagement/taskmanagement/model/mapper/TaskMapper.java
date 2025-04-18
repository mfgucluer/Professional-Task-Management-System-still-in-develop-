package com.taskmanagement.taskmanagement.model.mapper;

import com.taskmanagement.taskmanagement.domain.Task;
import com.taskmanagement.taskmanagement.model.dto.request.TaskInputDto;
import com.taskmanagement.taskmanagement.model.dto.response.TaskDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    Task taskInputDtoToTask(TaskInputDto taskInputDto);

    TaskDto taskInputDtoToTaskDto(TaskInputDto taskInputDto);
}
