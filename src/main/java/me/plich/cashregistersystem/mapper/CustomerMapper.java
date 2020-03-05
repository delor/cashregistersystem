package me.plich.cashregistersystem.mapper;

import me.plich.cashregistersystem.dto.CustomerDto;
import me.plich.cashregistersystem.model.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer convertCustomerDtoToCustomer(CustomerDto customerDto);
    CustomerDto convertCustomerToCustomerDto(Customer customer);
}
