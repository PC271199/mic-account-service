package com.example.sleep.mapstruct;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.sleep.DTO.UserDto;
import com.example.sleep.entities.User;




@Mapper(componentModel = "spring")

public interface UserMapper {


    User toUserEntity(UserDto userDto);
   
    UserDto toUserDTO(User user);

}
