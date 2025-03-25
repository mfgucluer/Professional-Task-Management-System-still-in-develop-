package com.taskmanagement.taskmanagement.services;

import com.taskmanagement.taskmanagement.model.dto.response.UserDto;
import com.taskmanagement.taskmanagement.model.dto.request.UserInputDto;

public interface UserService {

    public UserDto saveUser(UserInputDto user);

    public UserDto getUserById(Long id);

    public String updateUser(Long id, UserInputDto userInputDto);

    public void deleteUserById(Long id);

    public void demonstrateOrphanRemoval(Long id);

}