package com.taskmanagement.taskmanagement.Controller.impl;


import com.taskmanagement.taskmanagement.Controller.UserController;
import com.taskmanagement.taskmanagement.Response.DtoUser;
import com.taskmanagement.taskmanagement.Response.DtoUserInUp;
import com.taskmanagement.taskmanagement.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/api/user")
public class UserControllerImpl implements UserController {

   UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    @Override
    public DtoUser saveUser(@Valid @RequestBody DtoUserInUp dtoUserInUp) {
        return userService.saveUser(dtoUserInUp);
    }

    @GetMapping("/get/{id}")
    @Override
    public DtoUser getUserById(@PathVariable(name = "id") Long userId) {
        return userService.getUserById(userId);
    }

    @PutMapping("/update/{id}")
    @Override
    public String updateUser(@PathVariable(name = "id") Long userId, @Valid @RequestBody DtoUserInUp dtoUserInUp) {
        return userService.updateUser(userId,dtoUserInUp);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public void deleteUserById(@PathVariable(name = "id") Long userId) {
        userService.deleteUserById(userId);
    }

    @GetMapping("/orphan/{id}")
    public void orphanRemove(@PathVariable(name = "id") Long userId){
        userService.demonstrateOrphanRemoval(userId);
    }

}
