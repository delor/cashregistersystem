package me.plich.cashregistersystem.controller;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiOperation;
import me.plich.cashregistersystem.dto.CustomerDto;
import me.plich.cashregistersystem.dto.DeviceDto;
import me.plich.cashregistersystem.dto.OrderDto;
import me.plich.cashregistersystem.mapper.CustomerMapper;
import me.plich.cashregistersystem.mapper.DeviceMapper;
import me.plich.cashregistersystem.mapper.OrderMapper;
import me.plich.cashregistersystem.model.Customer;
import me.plich.cashregistersystem.model.Device;
import me.plich.cashregistersystem.model.Order;
import me.plich.cashregistersystem.model.View;
import me.plich.cashregistersystem.service.ICustomerService;
import me.plich.cashregistersystem.service.IDeviceService;
import me.plich.cashregistersystem.service.IOrderService;
import me.plich.cashregistersystem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
@ApiOperation("Set of endpoints for Creating, Retrieving, Updating and Deleting of orders.")
public class OrderController {


    private IOrderService orderService;
    private IUserService userService;
    private IDeviceService deviceService;
    private ICustomerService customerService;
    private OrderMapper orderMapper;
    private DeviceMapper deviceMapper;
    private CustomerMapper customerMapper;

    @Autowired
    public OrderController(@Qualifier("orderService") IOrderService orderService,
                           @Qualifier("userService") IUserService userService,
                           @Qualifier("deviceService") IDeviceService deviceService,
                           @Qualifier("customerService") ICustomerService customerService,
                           OrderMapper orderMapper,
                           DeviceMapper deviceMapper,
                           CustomerMapper customerMapper) {
        this.orderService = orderService;
        this.userService = userService;
        this.deviceService = deviceService;
        this.customerService = customerService;
        this.orderMapper = orderMapper;
        this.deviceMapper = deviceMapper;
        this.customerMapper = customerMapper;
    }

    @PostMapping
    @ApiOperation("Creates new order")
    public ResponseEntity<OrderDto> addOrder(@RequestBody OrderDto orderDto, @RequestHeader Long deviceID) {
        Long userId = userService.getCurrentLoggedUserId();
        Order orderFromDto = orderMapper.convertOrderDtoToOrder(orderDto);
        Order createdOrder = orderService.addOrder(userId, orderFromDto, deviceID);
        OrderDto createdOrderDto = orderMapper.convertOrderToOrderDto(createdOrder);
        return new ResponseEntity(createdOrderDto, HttpStatus.CREATED);
    }

    @GetMapping
    @JsonView(View.Public.class)
    @ApiOperation("Returns list of all user orders")
    public ResponseEntity<List<OrderDto>> getAllUserOrders() {
        Long userId = userService.getCurrentLoggedUserId();
        List<Order> orderList = orderService.findAllUsersOrders(userId);
        List<OrderDto> ordersDto = orderList.stream()
                .map(order -> orderMapper.convertOrderToOrderDto(order)) //przeanalizować możliwość wykorzystania referencji do metody
                .collect(Collectors.toList());
        return new ResponseEntity(ordersDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Deletes order with a specific id from system")
    public ResponseEntity deleteOrder(@PathVariable Long orderId) {
        Long userId = userService.getCurrentLoggedUserId();
        orderService.deleteOrder(userId, orderId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Returns a order with a specific id")
    public ResponseEntity<OrderDto> getOrder(@PathVariable Long orderId) {
        Long userId = userService.getCurrentLoggedUserId();
        Order order = orderService.getOrder(userId, orderId);
        OrderDto orderDto = orderMapper.convertOrderToOrderDto(order);
        return new ResponseEntity(orderDto, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    @ApiOperation("Updates order with a specific id")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable Long orderId, @RequestBody OrderDto orderDto) {
        Long userId = userService.getCurrentLoggedUserId();
        Order orderFromDto = orderMapper.convertOrderDtoToOrder(orderDto);
        Order updatedOrder = orderService.updateOrder(userId, orderId, orderFromDto);
        OrderDto updatedCustomerDto = orderMapper.convertOrderToOrderDto(updatedOrder);
        return new ResponseEntity(updatedCustomerDto, HttpStatus.OK);
    }

    @GetMapping("/{id}/devices")
    @JsonView(View.Public.class)
    @ApiOperation("Returns devices from order with a specified id")
    public ResponseEntity<DeviceDto> getOrdersDevice(@PathVariable Long orderId) {
        Long userId = userService.getCurrentLoggedUserId();
        Device ordersDevice = deviceService.getOrdersDevice(userId, orderId);
        DeviceDto  deviceDto = deviceMapper.convertDevicetoDeviceDto(ordersDevice);
        return new ResponseEntity(deviceDto, HttpStatus.OK);
    }

    @GetMapping("/{id}/customers")
    @JsonView(View.Public.class)
    @ApiOperation("Returns customer from order with a specified id")
    public ResponseEntity<CustomerDto> getOrdersCustomer(@PathVariable Long orderId) {
        Long userId = userService.getCurrentLoggedUserId();
        Customer ordersCustomer = customerService.getOrdersCustomer(userId, orderId);
        CustomerDto  customerDto = customerMapper.convertCustomerToCustomerDto(ordersCustomer);
        return new ResponseEntity(customerDto, HttpStatus.OK);
    }


}
