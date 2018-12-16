package me.plich.cashregistersystem.controller;

import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.plich.cashregistersystem.model.User;
import me.plich.cashregistersystem.model.View;

import me.plich.cashregistersystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Api(description = "Set of endpoints for Creating, Retrieving, Updating and Deleting of users.")
public class UserController {

    @Autowired
    private UserService userService;


    @JsonView(View.Public.class)
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Returns a user with a specific id")
    public User getUser() {
        return userService.getUser();
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




}
