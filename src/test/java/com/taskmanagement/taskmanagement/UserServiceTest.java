package com.taskmanagement.taskmanagement;


import com.taskmanagement.taskmanagement.domain.User;
import com.taskmanagement.taskmanagement.model.dto.request.UserInputDto;
import com.taskmanagement.taskmanagement.model.dto.response.UserDto;
import com.taskmanagement.taskmanagement.repository.UserRepository;
import com.taskmanagement.taskmanagement.services.impl.UserServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    @DisplayName("Geçerli Kullanıcı Girişi ile Kullanıcı Kaydetme Testi")
    public void saveUser_givenValidInput_shouldReturnUserDtoAndSaveUser() {
        User user = new User(
                1L,
                "john_doe",
                "securePassword",
                "john@example.com",
                new ArrayList<>()
        );

        UserInputDto userInputDto = new UserInputDto(
                user.getUsername(),
                user.getPassword(),
                user.getEmail()
        );

        when(userRepository.save(any(User.class))).thenReturn(user);

        UserDto result = userService.saveUser(userInputDto);

        assertEquals(user.getUsername(), result.getUsername());
        assertEquals(user.getEmail(), result.getEmail());

        verify(userRepository, times(1)).save(any(User.class));
    }
}

