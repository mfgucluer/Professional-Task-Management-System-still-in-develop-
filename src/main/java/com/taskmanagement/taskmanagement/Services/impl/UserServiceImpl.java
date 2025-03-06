package com.taskmanagement.taskmanagement.Services.impl;

import com.taskmanagement.taskmanagement.Domain.User;
import com.taskmanagement.taskmanagement.Repository.UserRepository;
import com.taskmanagement.taskmanagement.Response.DtoUser;
import com.taskmanagement.taskmanagement.Response.DtoUserInUp;
import com.taskmanagement.taskmanagement.Services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

   UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public DtoUser saveUser(DtoUserInUp dtoUserInUp) {
        User newUser = new User();
        DtoUser dtoUser = new DtoUser();
        newUser.setUsername(dtoUserInUp.getUsername());
        newUser.setPassword(dtoUserInUp.getPassword());
        newUser.setEmail(dtoUserInUp.getEmail());
        User dbUser = userRepository.save(newUser);
        dtoUser.setUsername(dtoUserInUp.getUsername());
        return dtoUser;
    }
}
