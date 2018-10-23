package me.plich.cashregistersystem.controller;

import com.fasterxml.jackson.annotation.JsonView;

import me.plich.cashregistersystem.model.User;
import me.plich.cashregistersystem.model.View;

import me.plich.cashregistersystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
//     for admin only
//    @GetMapping
//    @JsonView(View.Public.class)
//    public List<User> getAllUsers() {
//        return userService.getAllUsers();
//    }
    @JsonView(View.Public.class)
    @GetMapping
    public User getUser() {
        return userService.getUser(userService.currentLoggedUserId());
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }




}
