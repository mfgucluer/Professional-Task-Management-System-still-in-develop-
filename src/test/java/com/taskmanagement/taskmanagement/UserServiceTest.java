package com.taskmanagement.taskmanagement;

import com.taskmanagement.taskmanagement.domain.User;
import com.taskmanagement.taskmanagement.model.dto.request.UserInputDto;
import com.taskmanagement.taskmanagement.model.dto.response.UserDto;
import com.taskmanagement.taskmanagement.repository.UserRepository;
import com.taskmanagement.taskmanagement.services.impl.UserServiceImpl;
import com.taskmanagement.taskmanagement.model.mapper.UserMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    @DisplayName("Geçerli Kullanıcı Girişi ile Kullanıcı Kaydetme Testi")
    public void saveUser_givenValidInput_shouldReturnUserDtoAndSaveUser() {

        UserInputDto userInputDto = new UserInputDto("john_doe", "securePassword", "john@example.com");

        User user = new User(
                1L,
                "john_doe",
                "securePassword",
                "john@example.com",
                new ArrayList<>()
        );

        UserDto userDto = new UserDto("john_doe", "john@example.com");

        when(userMapper.userInputDtoToUser(any(UserInputDto.class))).thenReturn(user);
        when(userMapper.userInputDtoToDto(any(UserInputDto.class))).thenReturn(userDto);

        when(userRepository.save(any(User.class))).thenReturn(user);

        UserDto result = userService.saveUser(userInputDto);

        assertEquals(userDto.getUsername(), result.getUsername());
        assertEquals(userDto.getEmail(), result.getEmail());

        verify(userMapper, times(1)).userInputDtoToUser(userInputDto);
        verify(userRepository, times(1)).save(user);
        verify(userMapper, times(1)).userInputDtoToDto(userInputDto);
    }

    void getUsers_givenValidInput_shouldReturnUsers() {

    }








}
