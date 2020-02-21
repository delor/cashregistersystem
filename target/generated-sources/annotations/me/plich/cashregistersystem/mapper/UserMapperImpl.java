package me.plich.cashregistersystem.mapper;

import javax.annotation.Generated;
import me.plich.cashregistersystem.DTO.AddressDto;
import me.plich.cashregistersystem.DTO.UserDto;
import me.plich.cashregistersystem.model.Address;
import me.plich.cashregistersystem.model.User;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-02-22T00:41:30+0100",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_232 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User convertUserDtoToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setNip( userDto.getNip() );
        user.setRegon( userDto.getRegon() );
        user.setCompanyName( userDto.getCompanyName() );
        user.setUsername( userDto.getUsername() );
        user.setTelephone( userDto.getTelephone() );
        user.setEmail( userDto.getEmail() );
        user.setPassword( userDto.getPassword() );
        user.setAddress( addressDtoToAddress( userDto.getAddress() ) );

        return user;
    }

    @Override
    public UserDto convertUserToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setNip( user.getNip() );
        userDto.setRegon( user.getRegon() );
        userDto.setCompanyName( user.getCompanyName() );
        userDto.setUsername( user.getUsername() );
        userDto.setTelephone( user.getTelephone() );
        userDto.setEmail( user.getEmail() );
        userDto.setPassword( user.getPassword() );
        userDto.setAddress( addressToAddressDto( user.getAddress() ) );

        return userDto;
    }

    protected Address addressDtoToAddress(AddressDto addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        Address address = new Address();

        address.setId( addressDto.getId() );
        address.setStreet( addressDto.getStreet() );
        address.setHouseNumber( addressDto.getHouseNumber() );
        address.setFlatNumber( addressDto.getFlatNumber() );
        address.setZipCode( addressDto.getZipCode() );
        address.setCity( addressDto.getCity() );

        return address;
    }

    protected AddressDto addressToAddressDto(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDto addressDto = new AddressDto();

        addressDto.setStreet( address.getStreet() );
        addressDto.setHouseNumber( address.getHouseNumber() );
        addressDto.setFlatNumber( address.getFlatNumber() );
        addressDto.setZipCode( address.getZipCode() );
        addressDto.setCity( address.getCity() );
        addressDto.setId( address.getId() );

        return addressDto;
    }
}
