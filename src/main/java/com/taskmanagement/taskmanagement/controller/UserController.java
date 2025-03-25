package com.taskmanagement.taskmanagement.controller;

import com.taskmanagement.taskmanagement.model.dto.response.UserDto;
import com.taskmanagement.taskmanagement.model.dto.request.UserInputDto;
import org.springframework.http.ResponseEntity;


public interface UserController {

    ResponseEntity<UserDto> createUser(UserInputDto userInputDto);

    ResponseEntity<UserDto> getUserById(Long id);

    ResponseEntity<String> updateUser(Long id, UserInputDto userInputDto);

    ResponseEntity<Void> deleteUser(Long id);
}
