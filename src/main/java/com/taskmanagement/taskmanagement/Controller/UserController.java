package com.taskmanagement.taskmanagement.Controller;

import com.taskmanagement.taskmanagement.Response.DtoUser;
import com.taskmanagement.taskmanagement.Response.DtoUserInUp;
import org.springframework.http.ResponseEntity;

public interface UserController {
    ResponseEntity<DtoUser> createUser(DtoUserInUp dtoUserInUp);

    ResponseEntity<DtoUser> getUserById(Long userId);

    ResponseEntity<String> updateUser(Long userId, DtoUserInUp dtoUserInUp);

    ResponseEntity<Void> deleteUser(Long userId);
}
