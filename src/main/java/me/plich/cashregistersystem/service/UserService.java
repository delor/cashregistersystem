package me.plich.cashregistersystem.service;


import me.plich.cashregistersystem.DTO.UserDto;
import me.plich.cashregistersystem.mapper.UserMapper;
import me.plich.cashregistersystem.model.Address;
import me.plich.cashregistersystem.model.User;
import me.plich.cashregistersystem.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashSet;
import java.util.Set;


@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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

    public void updateUser(@RequestBody UserDto userDto) {
        System.out.println("userDto = "+userDto);
        User userToUpdate = userRepository.getOne(currentLoggedUserId());
        Long userAddressId = userToUpdate.getAddress().getId();
        User userFromDto = userMapper.convertUserDtoToUser(userDto);
        System.out.println("userFromDto = "+userFromDto);

        BeanUtils.copyProperties(userFromDto, userToUpdate, getNullPropertyNames(userFromDto));
        userToUpdate.getAddress().setId(userAddressId);
        userRepository.save(userToUpdate);
    }

    public static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

//    public UserDto convertToDto(User user) {
//        UserDto userDto = modelMapper.map(user, UserDto.class);
//        Address address = modelMapper.map(address, Address.class);
//        return userDto;
//    }
//
//    public User convertToEntity(UserDto userDto) {
//        User user = modelMapper.map(userDto, User.class);
//
//        return user;
//    }
}
