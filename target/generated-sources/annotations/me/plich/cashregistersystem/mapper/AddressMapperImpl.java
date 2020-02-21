package me.plich.cashregistersystem.mapper;

import javax.annotation.Generated;
import me.plich.cashregistersystem.DTO.AddressDto;
import me.plich.cashregistersystem.model.Address;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-02-21T08:06:08+0100",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_242 (Private Build)"
)
@Component
public class AddressMapperImpl implements AddressMapper {

    @Override
    public Address convertAddressDtoToAddress(AddressDto addressDto) {
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

    @Override
    public AddressDto convertAddressToAddressDto(Address address) {
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
