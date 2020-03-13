package me.plich.cashregistersystem.mapper;


import me.plich.cashregistersystem.dto.UserDto;
import me.plich.cashregistersystem.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface UserMapper {

    User convertUserDtoToUser(UserDto userDto);
    @Mapping(target = "password", ignore = true)
    UserDto convertUserToUserDto(User user);

}
