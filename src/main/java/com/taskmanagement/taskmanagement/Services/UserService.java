package com.taskmanagement.taskmanagement.Services;

import com.taskmanagement.taskmanagement.Response.DtoUser;
import com.taskmanagement.taskmanagement.Response.DtoUserInUp;

public interface UserService {

    public DtoUser saveUser(DtoUserInUp user);

}
