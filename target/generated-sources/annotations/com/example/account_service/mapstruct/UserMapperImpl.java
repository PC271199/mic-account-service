package com.example.account_service.mapstruct;

import com.example.account_service.DTO.UserDto;
import com.example.account_service.entities.User;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-13T19:09:09+0700",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 1.3.1200.v20200916-0645, environment: Java 15.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toUserEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDto.getId() );
        user.setName( userDto.getName() );
        user.setAddress( userDto.getAddress() );
        user.setAge( userDto.getAge() );
        user.setEmail( userDto.getEmail() );

        return user;
    }

    @Override
    public UserDto toUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setName( user.getName() );
        userDto.setAddress( user.getAddress() );
        userDto.setAge( user.getAge() );
        userDto.setEmail( user.getEmail() );

        return userDto;
    }
}
