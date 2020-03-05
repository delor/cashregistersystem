package me.plich.cashregistersystem.controller;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiOperation;
import me.plich.cashregistersystem.dto.UserDto;
import me.plich.cashregistersystem.mapper.UserMapper;
import me.plich.cashregistersystem.model.View;
import me.plich.cashregistersystem.model.User;
import me.plich.cashregistersystem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;





@RestController
@RequestMapping("/users")
@ApiOperation("Set of endpoints for Creating, Retrieving, Updating and Deleting of users.")
public class UserController {


    private IUserService userService;
    UserMapper userMapper;

    @Autowired
    public UserController(@Qualifier("userService") IUserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @JsonView(View.Public.class)
    @GetMapping
    @ApiOperation("Returns a logged user")
    public ResponseEntity<UserDto> getUser() {
        Long userId = userService.getCurrentLoggedUserId();
        User user = userService.getUser(userId);
        UserDto userDto = userMapper.convertUserToUserDto(user);
        return new ResponseEntity(userDto, HttpStatus.OK);
    }


    @DeleteMapping
    @ApiOperation("Delete current logged user")
    public ResponseEntity deleteUser() {
        Long userId = userService.getCurrentLoggedUserId();
        userService.deleteUser(userId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @JsonView(View.Public.class)
    @PatchMapping
    @ApiOperation("Update current logged user")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {
        Long userId = userService.getCurrentLoggedUserId();
        User userFromDto = userMapper.convertUserDtoToUser(userDto);
        User updatedUser = userService.updateUser(userId, userFromDto);
        UserDto updatedUserDto = userMapper.convertUserToUserDto(updatedUser);
        return new ResponseEntity(updatedUserDto, HttpStatus.OK);
    }
}
