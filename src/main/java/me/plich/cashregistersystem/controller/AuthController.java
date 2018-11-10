package me.plich.cashregistersystem.controller;

import me.plich.cashregistersystem.exception.AppException;
import me.plich.cashregistersystem.model.Role;
import me.plich.cashregistersystem.model.RoleName;
import me.plich.cashregistersystem.model.User;
import me.plich.cashregistersystem.payload.ApiResponse;
import me.plich.cashregistersystem.payload.JwtAuthenticationResponse;
import me.plich.cashregistersystem.payload.LoginRequest;
//import me.plich.cashregistersystem.payload.SignUpRequest;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;

@RestController
@RequestMapping
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @PostMapping("/signin")
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
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user) {
        if(userRepository.existsByUsername(user.getUsername())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(user.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByNip(user.getNip())) {
            return new ResponseEntity(new ApiResponse(false, "Nip number already in use!"),
                    HttpStatus.BAD_REQUEST);
        }


        User newUser = new User(user.getNip(), user.getName(), user.getUsername(), user.getStreet(), user.getHouseNumber(), user.getFlatNumber(), user.getZipCode(), user.getPlace(), user.getVoivodeship(), user.getTelephone(), user.getEmail(), user.getPassword());

        newUser.setPassword(passwordEncoder.encode(user.getPassword()));

        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new AppException("User Role not set."));

        newUser.setRoles(Collections.singleton(userRole));

        User result = userRepository.save(newUser);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }
}