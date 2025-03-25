package com.taskmanagement.taskmanagement.services.impl;

import com.taskmanagement.taskmanagement.domain.Task;
import com.taskmanagement.taskmanagement.domain.User;
import com.taskmanagement.taskmanagement.exception.BaseException;
import com.taskmanagement.taskmanagement.exception.ErrorMessage;
import com.taskmanagement.taskmanagement.exception.MessageType;
import com.taskmanagement.taskmanagement.model.mapper.UserMapper;
import com.taskmanagement.taskmanagement.repository.UserRepository;
import com.taskmanagement.taskmanagement.model.dto.response.UserDto;
import com.taskmanagement.taskmanagement.model.dto.request.UserInputDto;
import com.taskmanagement.taskmanagement.services.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

   UserRepository userRepository;
   UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Transactional(readOnly = false)
    @Override
    public UserDto saveUser(UserInputDto userInputDto) {
        User user = userMapper.userInputDtoToUser(userInputDto);
        User dbUser = userRepository.save(user);
        return userMapper.userInputDtoToDto(userInputDto);
    }

    @Transactional
    @Override
    public UserDto getUserById(Long id) {
        Optional<User> user =  userRepository.findById(id);
        if(user.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString()+" id user not found"));
           }
        User actualDbUser = user.get();
        return userMapper.userToDto(actualDbUser);
    }

    @Transactional(readOnly = false)
    @Override
    public String updateUser(Long id, UserInputDto userInputDto) {
        Optional<User> user =  userRepository.findById(id);

        if(user.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString()+" id user not found"));
        }

        User actualDbUser = user.get();

        if(userInputDto.getUsername() != null){actualDbUser.setUsername(userInputDto.getUsername());}
        if(userInputDto.getEmail() != null){actualDbUser.setEmail(userInputDto.getEmail());}
        if(userInputDto.getPassword() != null){actualDbUser.setPassword(userInputDto.getPassword());}
        userRepository.save(actualDbUser);

        return "Basarili";
    }

    @Transactional(readOnly = false)
    @Override
    public void deleteUserById(Long id) {
        Optional<User> user =  userRepository.findById(id);
        if(user.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString()+" id user not found"));
        }
        userRepository.deleteById(id);
    }


    //Bu method orphanRemoval'i anlamak icin
    public void demonstrateOrphanRemoval(Long id) {

        User user = userRepository.findById(id).get(); /// 1. Adım: User'ı veritabanından getir

        Task task = user.getTasks().get(0); /// 2. Adım: User'ın task listesinden ilk task'ı al


        task.setUser(null);
        //user.getTasks().remove(task);  /// 3. Adım: Task'ı user'ın listesinden çıkar /// İlişki burada koparılıyor!

        userRepository.save(user);  /// 4. Adım: Değişiklikleri veritabanına kaydet
    }

}