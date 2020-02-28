package me.plich.cashregistersystem.mapper;

import me.plich.cashregistersystem.DTO.OrderDto;
import me.plich.cashregistersystem.model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order convertOrderDtoToOrder(OrderDto orderDto);
    OrderDto convertOrderToOrderDto(Order order);

}
