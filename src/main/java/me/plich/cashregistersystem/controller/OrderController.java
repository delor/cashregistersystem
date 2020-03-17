package me.plich.cashregistersystem.controller;

import me.plich.cashregistersystem.dto.CustomerDto;
import me.plich.cashregistersystem.dto.DeviceDto;
import me.plich.cashregistersystem.dto.LocationDto;
import me.plich.cashregistersystem.dto.OrderDto;
import me.plich.cashregistersystem.mapper.CustomerMapper;
import me.plich.cashregistersystem.mapper.DeviceMapper;
import me.plich.cashregistersystem.mapper.OrderMapper;
import me.plich.cashregistersystem.model.Customer;
import me.plich.cashregistersystem.model.Device;
import me.plich.cashregistersystem.model.Order;
import me.plich.cashregistersystem.service.ICustomerService;
import me.plich.cashregistersystem.service.IDeviceService;
import me.plich.cashregistersystem.service.IOrderService;
import me.plich.cashregistersystem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
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
    public ResponseEntity<EntityModel<OrderDto>> addOrder(@RequestBody OrderDto orderDto) {
        Long userId = userService.getCurrentLoggedUserId();
        Order orderFromDto = orderMapper.convertOrderDtoToOrder(orderDto);
        Order createdOrder = orderService.addOrder(userId, orderFromDto, orderDto.getDeviceId());
        OrderDto createdOrderDto = orderMapper.convertOrderToOrderDto(createdOrder);
        Link selfLink = WebMvcLinkBuilder.linkTo(OrderController.class).slash(createdOrderDto.getId()).withSelfRel();
        Link ordersLink = WebMvcLinkBuilder.linkTo(OrderController.class).withRel("orders");
        EntityModel<OrderDto> resource = new EntityModel<>(createdOrderDto, selfLink, ordersLink);
        return new ResponseEntity(resource, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<CollectionModel<OrderDto>> getAllUserOrders() {
        Long userId = userService.getCurrentLoggedUserId();
        List<Order> orderList = orderService.findAllUsersOrders(userId);
        List<OrderDto> ordersDto = orderList.stream()
                .map(order -> orderMapper.convertOrderToOrderDto(order)) //przeanalizować możliwość wykorzystania referencji do metody
                .collect(Collectors.toList());
        Link link = WebMvcLinkBuilder.linkTo(OrderController.class).withSelfRel();
        ordersDto.forEach(orderDto -> orderDto.add(WebMvcLinkBuilder.linkTo(OrderController.class).slash(orderDto.getId()).withSelfRel()));
        Link ordersLink = WebMvcLinkBuilder.linkTo(OrderController.class).withRel("orders");
        CollectionModel<OrderDto> resource = new CollectionModel<>(ordersDto, link, ordersLink);
        return new ResponseEntity(resource, HttpStatus.OK);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity deleteOrder(@PathVariable Long orderId) {
        Long userId = userService.getCurrentLoggedUserId();
        orderService.deleteOrder(userId, orderId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<EntityModel<OrderDto>> getOrder(@PathVariable Long orderId) {
        Long userId = userService.getCurrentLoggedUserId();
        Order order = orderService.getOrder(userId, orderId);
        OrderDto orderDto = orderMapper.convertOrderToOrderDto(order);
        Link selfLink = WebMvcLinkBuilder.linkTo(OrderController.class).slash(orderId).withSelfRel();
        Link ordersLink = WebMvcLinkBuilder.linkTo(OrderController.class).withRel("orders");
        EntityModel<OrderDto> resource = new EntityModel<>(orderDto, selfLink, ordersLink);
        return new ResponseEntity<>(resource, HttpStatus.OK);
    }

    @PatchMapping("/{orderId}")
    public ResponseEntity<EntityModel<OrderDto>> updateOrder(@PathVariable Long orderId, @RequestBody OrderDto orderDto) {
        Long userId = userService.getCurrentLoggedUserId();
        Order orderFromDto = orderMapper.convertOrderDtoToOrder(orderDto);
        Order updatedOrder = orderService.updateOrder(userId, orderId, orderFromDto);
        OrderDto updatedCustomerDto = orderMapper.convertOrderToOrderDto(updatedOrder);
        Link selfLink = WebMvcLinkBuilder.linkTo(OrderController.class).slash(updatedCustomerDto.getId()).withSelfRel();
        Link ordersLink = WebMvcLinkBuilder.linkTo(OrderController.class).withRel("orders");
        EntityModel<OrderDto> resource = new EntityModel<>(updatedCustomerDto, selfLink, ordersLink);
        return new ResponseEntity(resource, HttpStatus.OK);
    }

    @GetMapping("/{orderId}/devices")
    public ResponseEntity<EntityModel<DeviceDto>> getOrdersDevice(@PathVariable Long orderId) {
        Long userId = userService.getCurrentLoggedUserId();
        Device ordersDevice = deviceService.getOrdersDevice(userId, orderId);
        DeviceDto  deviceDto = deviceMapper.convertDevicetoDeviceDto(ordersDevice);
        Link link = WebMvcLinkBuilder.linkTo(OrderController.class).slash(orderId).withSelfRel();
        Link ordersLink = WebMvcLinkBuilder.linkTo(OrderController.class).withRel("orders");
        Link devicesLink = WebMvcLinkBuilder.linkTo(DeviceController.class).withRel("devices");
        EntityModel<DeviceDto> resource = new EntityModel<>(deviceDto, link, ordersLink, devicesLink);
        return new ResponseEntity<>(resource, HttpStatus.OK);
    }

    @GetMapping("/{orderId}/customers")
    public ResponseEntity<EntityModel<CustomerDto>> getOrdersCustomer(@PathVariable Long orderId) {
        Long userId = userService.getCurrentLoggedUserId();
        Customer ordersCustomer = customerService.getOrdersCustomer(userId, orderId);
        CustomerDto  customerDto = customerMapper.convertCustomerToCustomerDto(ordersCustomer);
        Link link = WebMvcLinkBuilder.linkTo(OrderController.class).slash(customerDto.getId()).withSelfRel();
        Link ordersLink = WebMvcLinkBuilder.linkTo(OrderController.class).withRel("orders");
        Link devicesLink = WebMvcLinkBuilder.linkTo(DeviceController.class).withRel("devices");
        EntityModel<CustomerDto> resource = new EntityModel<>(customerDto, link, ordersLink, devicesLink);
        return new ResponseEntity<>(resource, HttpStatus.OK);
    }


}
