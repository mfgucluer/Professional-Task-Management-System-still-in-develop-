package com.taskmanagement.taskmanagement.Controller.impl;

import com.taskmanagement.taskmanagement.Controller.UserController;
import com.taskmanagement.taskmanagement.Response.DtoUser;
import com.taskmanagement.taskmanagement.Response.DtoUserInUp;
import com.taskmanagement.taskmanagement.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserControllerImpl implements UserController {

   private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @Override
    public ResponseEntity<DtoUser> createUser(@Valid @RequestBody DtoUserInUp dtoUserInUp) {
        DtoUser user = userService.saveUser(dtoUserInUp);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<DtoUser> getUserById(@PathVariable(name = "id") Long userId) {
        DtoUser user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<String> updateUser(@PathVariable(name = "id") Long userId, @Valid @RequestBody DtoUserInUp dtoUserInUp) {
        String result = userService.updateUser(userId, dtoUserInUp);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> deleteUser(@PathVariable(name = "id") Long userId) {
        userService.deleteUserById(userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/orphan/{id}")
    public void orphanRemove(@PathVariable(name = "id") Long userId){
        userService.demonstrateOrphanRemoval(userId);
    }

}
