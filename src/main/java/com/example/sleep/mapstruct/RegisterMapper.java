package com.example.sleep.mapstruct;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.sleep.DTO.RegisterDto;
import com.example.sleep.entities.Account;

@Mapper(componentModel = "spring",uses = {UserMapper.class})
public interface RegisterMapper {
	@Mapping(source = "registerDto.userDto", target = "user")
	Account toAccountEntity(RegisterDto registerDto);
}
