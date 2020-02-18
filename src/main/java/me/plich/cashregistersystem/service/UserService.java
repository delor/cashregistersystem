package me.plich.cashregistersystem.service;

import me.plich.cashregistersystem.model.User;
import me.plich.cashregistersystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


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

    public void updateUser(@RequestBody User user) {
        User userToUpdate = userRepository.getOne(currentLoggedUserId());
        if(user.getNip() != null) {
            userToUpdate.setNip(user.getNip());
        }
        if(user.getName() != null) {
            userToUpdate.setName(user.getName());
        }
        if(user.getUsername() != null) {
            userToUpdate.setUsername(user.getUsername());
        }
        if(user.getTelephone() != null) {
            userToUpdate.setTelephone(user.getTelephone());
        }
        if(user.getEmail() != null) {
            userToUpdate.setEmail(user.getEmail());
        }
            userRepository.save(userToUpdate);

    }
}
