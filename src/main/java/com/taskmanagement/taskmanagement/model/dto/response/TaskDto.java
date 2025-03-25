package com.taskmanagement.taskmanagement.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

    private String title;

    private String description;

    private Boolean completed;

    private UserDto userDto;
}