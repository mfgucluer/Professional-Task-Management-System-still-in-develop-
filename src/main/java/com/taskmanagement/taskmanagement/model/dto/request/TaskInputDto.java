package com.taskmanagement.taskmanagement.model.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskInputDto {

    @NotEmpty(message = "Title cannot be empty!")
    private String title;

    private String description;

    private Long userId;

    private Boolean completed;

}