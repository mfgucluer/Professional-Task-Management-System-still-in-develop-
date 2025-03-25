package com.taskmanagement.taskmanagement.controller.impl;

import com.taskmanagement.taskmanagement.constants.ApiConstants;
import com.taskmanagement.taskmanagement.controller.UserController;
import com.taskmanagement.taskmanagement.model.dto.response.UserDto;
import com.taskmanagement.taskmanagement.model.dto.request.UserInputDto;
import com.taskmanagement.taskmanagement.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiConstants.USERS)
public class UserControllerImpl implements UserController {

    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @Override
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserInputDto userInputDto) {
        UserDto user = userService.saveUser(userInputDto);
        return ResponseEntity.ok(user);
    }

    @GetMapping(ApiConstants.USER_BY_ID)
    @Override
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping(ApiConstants.USER_BY_ID)
    @Override
    public ResponseEntity<String> updateUser(@PathVariable(name = "id") Long id, @Valid @RequestBody UserInputDto userInputDto) {
        String result = userService.updateUser(id, userInputDto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(ApiConstants.USER_BY_ID)
    @Override
    public ResponseEntity<Void> deleteUser(@PathVariable(name = "id") Long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(ApiConstants.ORPHAN_REMOVE)
    public void orphanRemove(@PathVariable(name = "id") Long userId) {
        userService.demonstrateOrphanRemoval(userId);
    }
}
