package com.example.account_service.mapstruct;

import com.example.account_service.DTO.AccountDto;
import com.example.account_service.entities.Account;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-13T19:45:12+0700",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 1.3.1200.v20200916-0645, environment: Java 15.0.1 (Oracle Corporation)"
)
@Component
public class AccountMapperImpl implements AccountMapper {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Account toAccountEntity(AccountDto accountDto) {
        if ( accountDto == null ) {
            return null;
        }

        Account account = new Account();

        account.setUser( userMapper.toUserEntity( accountDto.getUserDto() ) );
        account.setId( accountDto.getId() );
        account.setPassword( accountDto.getPassword() );
        account.setUsername( accountDto.getUsername() );

        return account;
    }

    @Override
    public AccountDto toAccountDTO(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountDto accountDto = new AccountDto();

        accountDto.setUserDto( userMapper.toUserDTO( account.getUser() ) );
        accountDto.setId( account.getId() );
        accountDto.setPassword( account.getPassword() );
        accountDto.setUsername( account.getUsername() );

        return accountDto;
    }

    @Override
    public List<AccountDto> toAccountDTOs(List<Account> accounts) {
        if ( accounts == null ) {
            return null;
        }

        List<AccountDto> list = new ArrayList<AccountDto>( accounts.size() );
        for ( Account account : accounts ) {
            list.add( toAccountDTO( account ) );
        }

        return list;
    }
}
