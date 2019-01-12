package me.plich.cashregistersystem.controller;

import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.plich.cashregistersystem.DTO.UserDto;
import me.plich.cashregistersystem.model.User;
import me.plich.cashregistersystem.model.View;

import me.plich.cashregistersystem.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/users")
@Api(description = "Set of endpoints for Creating, Retrieving, Updating and Deleting of users.")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;


//    @JsonView(View.Public.class)
//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    @ApiOperation("Returns a user with a specific id")
//    public User getUser() {
//        return userService.getUser();
//    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Returns a user")
    public UserDto getUser() {
        return convertToDto(userService.getUser());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Deletes user with a specific id from system")
    public void deleteUser() {
        userService.deleteUser();
    }

    @PatchMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Updates the user")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    private UserDto convertToDto(User user) {
        UserDto userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }

    private User convertToEntity(UserDto userDto) throws ParseException {
        User user = modelMapper.map(userDto, User.class);
        return user;
    }




}
