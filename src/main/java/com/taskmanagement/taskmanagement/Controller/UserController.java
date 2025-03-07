package com.taskmanagement.taskmanagement.Controller;

import com.taskmanagement.taskmanagement.Response.DtoUser;
import com.taskmanagement.taskmanagement.Response.DtoUserInUp;

public interface UserController {

    public DtoUser saveUser(DtoUserInUp dtoUserInUp);

    public DtoUser getUserById(Long userId);

    public String updateUser(Long userId, DtoUserInUp dtoUserInUp);

    public void deleteUserById(Long userId);
}
