package com.taskmanagement.taskmanagement.Response;

import com.taskmanagement.taskmanagement.Domain.Task;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

import java.util.List;

public class DtoUser {

    private String username;

    private String email;

    public DtoUser(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public DtoUser() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}