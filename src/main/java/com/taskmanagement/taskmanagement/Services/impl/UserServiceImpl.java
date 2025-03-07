package com.taskmanagement.taskmanagement.Services.impl;

import com.taskmanagement.taskmanagement.Domain.User;
import com.taskmanagement.taskmanagement.Repository.UserRepository;
import com.taskmanagement.taskmanagement.Response.DtoUser;
import com.taskmanagement.taskmanagement.Response.DtoUserInUp;
import com.taskmanagement.taskmanagement.Services.UserService;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

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
        dtoUser.setEmail(dtoUserInUp.getEmail());
        return dtoUser;
    }

    @Override
    public DtoUser getUserById(Long userId) {

        Optional<User> user =  userRepository.findById(userId);
        if(user.isEmpty()){return null;}

        DtoUser dtoUser = new DtoUser();
        dtoUser.setUsername(user.get().getUsername());
        dtoUser.setEmail(user.get().getEmail());

        return dtoUser;
    }

    @Override
    public String updateUser(Long userId, DtoUserInUp dtoUserInUp) {
        Optional<User> user =  userRepository.findById(userId);
        if(user.isEmpty()){return null;}
        User actualDbUser = user.get();

        if(dtoUserInUp.getUsername() != null){actualDbUser.setUsername(dtoUserInUp.getUsername());}
        if(dtoUserInUp.getEmail() != null){actualDbUser.setEmail(dtoUserInUp.getEmail());}
        if(dtoUserInUp.getPassword() != null){actualDbUser.setPassword(dtoUserInUp.getPassword());}
        userRepository.save(actualDbUser);

        return "Basarili";
    }

    @Override
    public void deleteUserById(Long userId) {
        if(userId != null && userRepository.findById(userId).isPresent()){
            userRepository.deleteById(userId);
        }

    }
}
