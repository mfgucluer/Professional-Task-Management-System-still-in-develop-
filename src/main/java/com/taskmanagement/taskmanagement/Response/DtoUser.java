package com.taskmanagement.taskmanagement.Response;

import com.taskmanagement.taskmanagement.Domain.Task;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

import java.util.List;

public class DtoUser {

    private String username;

    public DtoUser(){

    }

    public DtoUser(String username){
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}