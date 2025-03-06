package com.taskmanagement.taskmanagement.Response;

import com.taskmanagement.taskmanagement.Domain.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class DtoTask {

    private String title;

    private String description;

    private Boolean completed;

    private DtoUser dtoUser;

    public DtoTask() {

    }

    public DtoTask(String title, String description, Boolean completed, DtoUser dtoUser) {
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.dtoUser = dtoUser;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public DtoUser getDtoUser() {
        return dtoUser;
    }

    public void setDtoUser(DtoUser dtoUser) {
        this.dtoUser = dtoUser;
    }
}
