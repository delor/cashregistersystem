package me.plich.cashregistersystem.controller;

import com.fasterxml.jackson.annotation.JsonView;

import me.plich.cashregistersystem.model.User;
import me.plich.cashregistersystem.model.View;

import me.plich.cashregistersystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @JsonView(View.Public.class)
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public User getUser() {
        return userService.getUser();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser() {
        userService.deleteUser();
    }




}
