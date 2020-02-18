package me.plich.cashregistersystem.mapper;

import me.plich.cashregistersystem.DTO.UserDto;
import me.plich.cashregistersystem.model.Address;
import me.plich.cashregistersystem.model.User;



public interface UserMapper {

    User convertUserDtoToUser(UserDto userDto);
    UserDto convertUserToUserDto(User user);
}
