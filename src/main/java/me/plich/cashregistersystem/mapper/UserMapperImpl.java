//package me.plich.cashregistersystem.mapper;
//
//import me.plich.cashregistersystem.DTO.UserDto;
//import me.plich.cashregistersystem.model.Address;
//import me.plich.cashregistersystem.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service("customUserMapper")
//public class UserMapperImpl implements UserMapper{
//
//    PasswordEncoder passwordEncoder;
//    @Autowired
//    public UserMapperImpl(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public User convertUserDtoToUser(UserDto userDto) {
////dorzucić sprawdzanie czy pola są, w razie braku  wymaganych pól rzucić wyjątek
//        User user = new User();
//
//        user.setNip(userDto.getNip());
//        user.setRegon(userDto.getRegon());
//        user.setName(userDto.getName());
//        user.setUsername(userDto.getUsername());
//        user.setEmail(userDto.getEmail());
//        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
//        user.setTelephone(userDto.getTelephone());
//
//        Address address = new Address();
//        address.setCity(userDto.getCity());
//        address.setStreet(userDto.getStreet());
//        address.setHouseNumber(userDto.getHouseNumber());
//        address.setFlatNumber(userDto.getFlatNumber());
//        address.setZipCode(userDto.getZipCode());
//        user.setAddress(address);
//
//        return user;
//    }
//
//    @Override
//    public UserDto convertUserToUserDto(User user) {
//
//        UserDto userDto = new UserDto();
//        userDto.setId(user.getId());
//        userDto.setName(user.getName());
//        userDto.setUsername(user.getUsername());
//        userDto.setId(user.getId());
//        userDto.setNip(user.getNip());
//        userDto.setRegon(user.getRegon());
//        userDto.setEmail(user.getEmail());
//        userDto.setCity(user.getAddress().getCity());
//        userDto.setStreet(user.getAddress().getStreet());
//        userDto.setHouseNumber(user.getAddress().getHouseNumber());
//        userDto.setFlatNumber(user.getAddress().getFlatNumber());
//        userDto.setZipCode(user.getAddress().getZipCode());
//        userDto.setTelephone(user.getTelephone());
//
//        return userDto;
//
//    }
//}
