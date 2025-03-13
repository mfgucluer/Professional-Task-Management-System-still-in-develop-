package com.taskmanagement.taskmanagement.Constants;

public class ApiConstants {

    // Base paths
    public static final String BASE_API_V1 = "/api/v1";
    public static final String TASKS = BASE_API_V1 + "/tasks";
    public static final String USERS = BASE_API_V1 + "/users";

    // Task Endpoints
    public static final String TASK_BY_ID = "/{id}";
    public static final String TASK_BY_USER_ID = "/user/{userId}";

    // User Endpoints
    public static final String USER_BY_ID = "/{id}";
    public static final String ORPHAN_REMOVE = "/orphan/{id}";
}
