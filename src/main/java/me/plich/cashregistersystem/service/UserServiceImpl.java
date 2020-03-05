package me.plich.cashregistersystem.service;

import me.plich.cashregistersystem.model.User;
import me.plich.cashregistersystem.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import static me.plich.cashregistersystem.utils.Utils.getNullPropertyNames;


@Service("userService")
public class UserServiceImpl implements IUserService {


    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public User getUser(Long userId) {
        return userRepository.getOne(userId);
    }

    public User updateUser(Long userId, User userFromDto) {
        User userToUpdate = userRepository.getOne(userId);
        Long userAddressId = userToUpdate.getAddress().getId();
        BeanUtils.copyProperties(userFromDto, userToUpdate, getNullPropertyNames(userFromDto));
        userToUpdate.getAddress().setId(userAddressId);
        return userRepository.save(userToUpdate);
    }

    public Long getCurrentLoggedUserId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Long userId = userRepository.findByUsername(auth.getName()).get().getId();
        return userId;
    }


}
