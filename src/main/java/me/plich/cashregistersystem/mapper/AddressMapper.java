package me.plich.cashregistersystem.mapper;

import me.plich.cashregistersystem.DTO.AddressDto;
import me.plich.cashregistersystem.model.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    Address convertAddressDtoToAddress(AddressDto addressDto);
    AddressDto convertAddressToAddressDto(Address address);
}
