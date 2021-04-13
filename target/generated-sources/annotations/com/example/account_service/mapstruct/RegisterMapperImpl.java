package com.example.account_service.mapstruct;

import com.example.account_service.DTO.RegisterDto;
import com.example.account_service.entities.Account;
import com.example.account_service.entities.Role;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-13T19:45:12+0700",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 1.3.1200.v20200916-0645, environment: Java 15.0.1 (Oracle Corporation)"
)
@Component
public class RegisterMapperImpl implements RegisterMapper {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Account toAccountEntity(RegisterDto registerDto) {
        if ( registerDto == null ) {
            return null;
        }

        Account account = new Account();

        account.setUser( userMapper.toUserEntity( registerDto.getUserDto() ) );
        account.setId( registerDto.getId() );
        account.setPassword( registerDto.getPassword() );
        Set<Role> set = registerDto.getRoles();
        if ( set != null ) {
            account.setRoles( new HashSet<Role>( set ) );
        }
        account.setUsername( registerDto.getUsername() );

        return account;
    }
}
