package com.taskmanagement.taskmanagement.Controller.impl;


import com.taskmanagement.taskmanagement.Controller.UserController;
import com.taskmanagement.taskmanagement.Response.DtoUser;
import com.taskmanagement.taskmanagement.Response.DtoUserInUp;
import com.taskmanagement.taskmanagement.Services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/user")
public class UserControllerImpl implements UserController {

   UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    @Override
    public DtoUser saveUser(@RequestBody DtoUserInUp dtoUserInUp) {
        return userService.saveUser(dtoUserInUp);
    }
}
