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

    public void registerUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

    public User getUser(@PathVariable Long id) {
        User user = userRepository.findById(id).get();
        return user;
    }

    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    public Long currentLoggedUserId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(auth.getName()).get();
        Long user_id = user.getId();
        return user_id;
    }
}
