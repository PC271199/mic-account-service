package com.example.sleep.mapstruct;

import java.util.List;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.example.sleep.DTO.AccountDto;
import com.example.sleep.entities.Account;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel  = "spring", uses = {UserMapper.class})
public interface AccountMapper {
	
    @Mapping(source = "accountDto.userDto", target = "user")
    Account toAccountEntity(AccountDto accountDto);
    @Mapping(source="account.id",target = "id")
    @Mapping(source = "account.user",target = "userDto")
    AccountDto toAccountDTO(Account account);
    
    List<AccountDto> toAccountDTOs(List<Account> accounts);
}
