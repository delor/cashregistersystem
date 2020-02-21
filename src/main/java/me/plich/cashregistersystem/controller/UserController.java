package me.plich.cashregistersystem.controller;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.plich.cashregistersystem.DTO.UserDto;
import me.plich.cashregistersystem.mapper.UserMapper;
import me.plich.cashregistersystem.model.User;
import me.plich.cashregistersystem.model.View;
import me.plich.cashregistersystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/users")
@Api(description = "Set of endpoints for Creating, Retrieving, Updating and Deleting of users.")
public class UserController {


    private UserService userService;
    UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @JsonView(View.Public.class)
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Returns a logged user")
    public UserDto getUser() {
        UserDto userDto = userMapper.convertUserToUserDto(userService.getUser());
        System.out.println(userDto);
        return userDto;
    }


    @DeleteMapping("/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Delete user")
    public void deleteUser() {
        userService.deleteUser();
    }

    @PatchMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Update user")
    public void updateUser(@RequestBody UserDto userDto) {
        userService.updateUser(userDto);
    }



}
