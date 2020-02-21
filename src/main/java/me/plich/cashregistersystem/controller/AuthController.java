package me.plich.cashregistersystem.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.plich.cashregistersystem.DTO.UserDto;
import me.plich.cashregistersystem.exception.AppException;
import me.plich.cashregistersystem.mapper.UserMapper;
import me.plich.cashregistersystem.model.Role;
import me.plich.cashregistersystem.model.RoleName;
import me.plich.cashregistersystem.model.User;
import me.plich.cashregistersystem.payload.ApiResponse;
import me.plich.cashregistersystem.payload.JwtAuthenticationResponse;
import me.plich.cashregistersystem.payload.LoginRequest;
import me.plich.cashregistersystem.repository.RoleRepository;
import me.plich.cashregistersystem.repository.UserRepository;
import me.plich.cashregistersystem.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;

@RestController
@Api(description = "Set of endpoint for singin and singup")
public class AuthController {


    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private JwtTokenProvider tokenProvider;
    private PasswordEncoder passwordEncoder;
    private UserMapper userMapper;



    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository, RoleRepository roleRepository, JwtTokenProvider tokenProvider, PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.tokenProvider = tokenProvider;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    @PostMapping("/signin")
    @ApiOperation("endpoint for logging in an existing user")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @PostMapping("/signup")
    @ApiOperation("endpoint for registering a new user")
    public ResponseEntity<?> registerUser( @RequestBody UserDto userDto) {
        System.out.println("userDto ="+userDto);

        User user = userMapper.convertUserDtoToUser(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));


        System.out.println("user = "+user);

        if(userRepository.existsByUsername(userDto.getUsername())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(userDto.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByNip(userDto.getNip())) {
            return new ResponseEntity(new ApiResponse(false, "Nip number already in use!"),
                    HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByRegon(userDto.getRegon())) {
            return new ResponseEntity(new ApiResponse(false, "Regon number already in use!"),
                    HttpStatus.BAD_REQUEST);
        }


        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new AppException("User Role not set."));

        user.setRoles(Collections.singleton(userRole));

        User result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}

