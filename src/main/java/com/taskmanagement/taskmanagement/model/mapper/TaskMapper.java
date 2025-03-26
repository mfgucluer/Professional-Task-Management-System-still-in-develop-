package com.taskmanagement.taskmanagement.model.mapper;

import com.taskmanagement.taskmanagement.domain.Task;
import com.taskmanagement.taskmanagement.model.dto.request.TaskInputDto;
import com.taskmanagement.taskmanagement.model.dto.response.TaskDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Mapping(target = "taskNo", ignore = true) // password alanını es geçiyoruz
    Task taskInputDtoToTask(TaskInputDto taskInputDto);

    TaskDto taskInputDtoToTaskDto(TaskInputDto taskInputDto);
}
