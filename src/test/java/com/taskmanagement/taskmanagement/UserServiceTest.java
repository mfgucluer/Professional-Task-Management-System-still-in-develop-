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
import java.util.Optional;

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





    @Test
    @DisplayName("Get User Testi")
    void getUsers_givenValidInput_shouldReturnUsers() {
        User user = new User(1L, "john_doe", "securePassword", "john@example.com", new ArrayList<>());
        Optional<User> optionalUser = Optional.of(user);

        UserDto userDto = new UserDto("john_doe", "john@example.com");

        when(userMapper.userToDto(any(User.class))).thenReturn(userDto);
        when(userRepository.findById(1L)).thenReturn(optionalUser);

        UserDto userDtoResponse = userService.getUserById(1L);

        assertEquals(user.getUsername(), userDtoResponse.getUsername());
        assertEquals(user.getEmail(), userDtoResponse.getEmail());

        verify(userRepository).findById(1L);
        verify(userMapper).userToDto(user);
    }

    @Test
    @DisplayName("UpdateUser Testi")
    void updateUser_givenValidInput_shouldReturn() {
        User oldDbUser = new User(1L, "john_doe", "securePassword", "john@example.com", new ArrayList<>());
        Optional<User> optionalUser = Optional.of(oldDbUser);

        UserInputDto userInputDto = new UserInputDto("Walter_White", "newPassword", "walterwhite@danger.com");

        when(userRepository.findById(1L)).thenReturn(optionalUser);

        User actualDbUser = optionalUser.get();

         actualDbUser.setUsername(userInputDto.getUsername());
         actualDbUser.setEmail(userInputDto.getEmail());
         actualDbUser.setPassword(userInputDto.getPassword());

        User newDbUser = new User(1L, "Walter_White", "newPassword", "walterwhite@danger.com", new ArrayList<>());

        when(userRepository.save(actualDbUser)).thenReturn(newDbUser);

        userService.updateUser(1L, userInputDto);

        assertEquals(actualDbUser.getUsername(), userInputDto.getUsername());
        assertEquals(actualDbUser.getEmail(), userInputDto.getEmail());
        assertEquals(actualDbUser.getPassword(), userInputDto.getPassword());

        verify(userRepository, times(1)).findById(1L);
    }
}