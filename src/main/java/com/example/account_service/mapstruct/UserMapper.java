package com.example.account_service.mapstruct;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import com.example.account_service.DTO.UserDto;
import com.example.account_service.entities.User;

@Mapper(componentModel = "spring")

public interface UserMapper {


    User toUserEntity(UserDto userDto);
   
    UserDto toUserDTO(User user);

}
