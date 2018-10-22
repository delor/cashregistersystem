package me.plich.cashregistersystem.controller;

import com.fasterxml.jackson.annotation.JsonView;

import me.plich.cashregistersystem.model.User;
import me.plich.cashregistersystem.model.View;

import me.plich.cashregistersystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void registerUser(@RequestBody User user) {
        userService.registerUser(user);
    }
    @GetMapping
    @JsonView(View.Public.class)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
    @JsonView(View.Public.class)
    @GetMapping("{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }



}
