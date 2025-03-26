package com.taskmanagement.taskmanagement.model.mapper;

import com.taskmanagement.taskmanagement.domain.User;
import com.taskmanagement.taskmanagement.model.dto.request.UserInputDto;
import com.taskmanagement.taskmanagement.model.dto.response.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto userToDto(User user);
    UserDto userInputDtoToDto(UserInputDto userInputDto);
    User userInputDtoToUser(UserInputDto userInputDto);
}
