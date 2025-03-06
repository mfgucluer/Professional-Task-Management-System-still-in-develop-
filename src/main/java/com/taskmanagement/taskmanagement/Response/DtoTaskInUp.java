package com.taskmanagement.taskmanagement.Response;

import com.taskmanagement.taskmanagement.Domain.User;

public class DtoTaskInUp {

    private String title;

    private String description;

    private Long userId;

    private Boolean completed;

    public DtoTaskInUp(){

    }

    public DtoTaskInUp(String title, String description, Long userId, Boolean completed) {
        this.title = title;
        this.description = description;
        this.userId = userId;
        this.completed = completed;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}