package com.taskmanagement.taskmanagement.Response;

import com.taskmanagement.taskmanagement.Domain.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class DtoTask {

    private String title;

    private DtoUser dtoUser;

    public DtoTask() {

    }

    public DtoTask(String title, DtoUser dtoUser) {
        this.title = title;
        this.dtoUser = dtoUser;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DtoUser getDtoUser() {
        return dtoUser;
    }

    public void setDtoUser(DtoUser dtoUser) {
        this.dtoUser = dtoUser;
    }
}
