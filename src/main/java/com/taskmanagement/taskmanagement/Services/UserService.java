package com.taskmanagement.taskmanagement.Services;

import com.taskmanagement.taskmanagement.Response.DtoUser;
import com.taskmanagement.taskmanagement.Response.DtoUserInUp;

public interface UserService {

    public DtoUser saveUser(DtoUserInUp user);

    public DtoUser getUserById(Long userId);

    public String updateUser(Long userId, DtoUserInUp dtoUserInUp);

    public void deleteUserById(Long userId);

    public void demonstrateOrphanRemoval(Long userId);

}