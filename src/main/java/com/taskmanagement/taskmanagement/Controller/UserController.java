package com.taskmanagement.taskmanagement.Controller;

import com.taskmanagement.taskmanagement.Response.DtoUser;
import com.taskmanagement.taskmanagement.Response.DtoUserInUp;
import com.taskmanagement.taskmanagement.Response.GenericResponse;
import org.springframework.http.ResponseEntity;

public interface UserController {
    ResponseEntity<GenericResponse<DtoUser>> createUser(DtoUserInUp dtoUserInUp);

    ResponseEntity<GenericResponse<DtoUser>> getUserById(Long userId);

    ResponseEntity<GenericResponse<String>> updateUser(Long userId, DtoUserInUp dtoUserInUp);

    ResponseEntity<GenericResponse<Void>> deleteUser(Long userId);
}
