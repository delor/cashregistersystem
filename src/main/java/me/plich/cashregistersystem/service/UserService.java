package me.plich.cashregistersystem.service;

import me.plich.cashregistersystem.model.User;
import me.plich.cashregistersystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void deleteUser() {
        userRepository.deleteById(currentLoggedUserId());
    }

    public User getUser() {
        return userRepository.getOne(currentLoggedUserId());
    }

    public Long currentLoggedUserId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(auth.getName()).get();
        Long user_id = user.getId();
        return user_id;
    }

    //todo: @Patch updateUser
}
