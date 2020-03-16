package me.plich.cashregistersystem.controller;

import me.plich.cashregistersystem.dto.UserDto;
import me.plich.cashregistersystem.mapper.UserMapper;
import me.plich.cashregistersystem.model.User;
import me.plich.cashregistersystem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {


    private IUserService userService;
    private UserMapper userMapper;

    @Autowired
    public UserController(@Qualifier("userService") IUserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }


    @GetMapping
    public ResponseEntity<EntityModel<UserDto>> getUser() {
        Long userId = userService.getCurrentLoggedUserId();
        User user = userService.getUser(userId);
        UserDto userDto = userMapper.convertUserToUserDto(user);
        Link link = WebMvcLinkBuilder.linkTo(UserController.class).withSelfRel();
        Link devicesLink = WebMvcLinkBuilder.linkTo(DeviceController.class).withRel("devices");
        Link locationsLink = WebMvcLinkBuilder.linkTo(LocationController.class).withRel("locations");
        Link customersLink = WebMvcLinkBuilder.linkTo(CustomerController.class).withRel("customers");
        Link ordersLink = WebMvcLinkBuilder.linkTo(OrderController.class).withRel("orders");
        Link servicemensLink = WebMvcLinkBuilder.linkTo(ServicemanController.class).withRel("servicemens");
        Link producersLink = WebMvcLinkBuilder.linkTo(ProducerController.class).withRel("producers");
        Link modelsLink = WebMvcLinkBuilder.linkTo(ModelController.class).withRel("models");
        EntityModel<UserDto> resource = new EntityModel<>(userDto, link, devicesLink, locationsLink, customersLink, ordersLink, servicemensLink, producersLink, modelsLink);
        return new ResponseEntity<>(resource, HttpStatus.OK);
    }


    @DeleteMapping
    public ResponseEntity deleteUser() {
        Long userId = userService.getCurrentLoggedUserId();
        userService.deleteUser(userId);
        return new ResponseEntity(HttpStatus.OK);
    }


    @PatchMapping
    public ResponseEntity<EntityModel<UserDto>> updateUser(@RequestBody UserDto userDto) {
        Long userId = userService.getCurrentLoggedUserId();
        User userFromDto = userMapper.convertUserDtoToUser(userDto);
        User updatedUser = userService.updateUser(userId, userFromDto);
        UserDto updatedUserDto = userMapper.convertUserToUserDto(updatedUser);
        Link link = WebMvcLinkBuilder.linkTo(UserController.class).withSelfRel();
        Link devicesLink = WebMvcLinkBuilder.linkTo(DeviceController.class).withRel("devices");
        Link locationsLink = WebMvcLinkBuilder.linkTo(LocationController.class).withRel("locations");
        Link customersLink = WebMvcLinkBuilder.linkTo(CustomerController.class).withRel("customers");
        Link ordersLink = WebMvcLinkBuilder.linkTo(OrderController.class).withRel("orders");
        Link servicemensLink = WebMvcLinkBuilder.linkTo(ServicemanController.class).withRel("servicemens");
        Link producersLink = WebMvcLinkBuilder.linkTo(ProducerController.class).withRel("producers");
        Link modelsLink = WebMvcLinkBuilder.linkTo(ModelController.class).withRel("models");
        EntityModel<UserDto> resource = new EntityModel<>(userDto, link, devicesLink, locationsLink, customersLink, ordersLink, servicemensLink, producersLink, modelsLink);
        return new ResponseEntity<>(resource, HttpStatus.OK);
    }
}
