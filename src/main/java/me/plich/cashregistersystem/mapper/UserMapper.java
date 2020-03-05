package me.plich.cashregistersystem.mapper;


import me.plich.cashregistersystem.dto.UserDto;
import me.plich.cashregistersystem.model.User;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {

    User convertUserDtoToUser(UserDto userDto);
    UserDto convertUserToUserDto(User user);

}
