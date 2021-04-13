package com.example.account_service.mapstruct;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.account_service.DTO.RegisterDto;
import com.example.account_service.entities.Account;
@Mapper(componentModel = "spring",uses = {UserMapper.class})
public interface RegisterMapper {
	@Mapping(source = "registerDto.userDto", target = "user")
	Account toAccountEntity(RegisterDto registerDto);
}
