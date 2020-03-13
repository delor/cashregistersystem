package me.plich.cashregistersystem.controller;

import me.plich.cashregistersystem.dto.CustomerDto;
import me.plich.cashregistersystem.dto.DeviceDto;
import me.plich.cashregistersystem.dto.LocationDto;
import me.plich.cashregistersystem.dto.OrderDto;
import me.plich.cashregistersystem.mapper.CustomerMapper;
import me.plich.cashregistersystem.mapper.DeviceMapper;
import me.plich.cashregistersystem.mapper.LocationMapper;
import me.plich.cashregistersystem.mapper.OrderMapper;
import me.plich.cashregistersystem.model.*;
import me.plich.cashregistersystem.service.*;
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
@RequestMapping("/customers")
public class CustomerController {


    private ICustomerService customerService;
    private IUserService userService;
    private IDeviceService deviceService;
    private ILocationService locationService;
    private IOrderService orderService;
    private CustomerMapper customerMapper;
    private DeviceMapper deviceMapper;
    private LocationMapper locationMapper;
    private OrderMapper orderMapper;

    @Autowired
    public CustomerController(@Qualifier("customerService") ICustomerService customerService,
                              @Qualifier("userService") IUserService userService,
                              @Qualifier("deviceService") IDeviceService deviceService,
                              @Qualifier("orderService") IOrderService orderService,
                              @Qualifier("locationService") ILocationService locationService,
                              CustomerMapper customerMapper,
                              DeviceMapper deviceMapper,
                              LocationMapper locationMapper,
                              OrderMapper orderMapper) {

        this.customerService = customerService;
        this.userService = userService;
        this.deviceService = deviceService;
        this.locationService = locationService;
        this.orderService = orderService;
        this.customerMapper = customerMapper;
        this.deviceMapper = deviceMapper;
        this.locationMapper = locationMapper;
        this.orderMapper = orderMapper;
    }

    @PostMapping
    public ResponseEntity<EntityModel<CustomerDto>> addCustomer(@RequestBody CustomerDto customerDto) {
        Long userId = userService.getCurrentLoggedUserId();
        Customer customerFromDto = customerMapper.convertCustomerDtoToCustomer(customerDto);
        Customer createdCustomer = customerService.addCustomer(userId, customerFromDto);
        CustomerDto createdCustomerDto = customerMapper.convertCustomerToCustomerDto(createdCustomer);
        Link selfLink = WebMvcLinkBuilder.linkTo(CustomerController.class).slash(createdCustomerDto.getId()).withSelfRel();
        Link customersLink = WebMvcLinkBuilder.linkTo(CustomerController.class).withRel("customers");
        EntityModel<CustomerDto> resource = new EntityModel<>(createdCustomerDto, selfLink, customersLink);
        return new ResponseEntity(resource, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<CollectionModel<CustomerDto>> getAllCustomers() {
        Long userId = userService.getCurrentLoggedUserId();
        List<Customer> customersList = customerService.getAllCustomers(userId);
        List<CustomerDto> customersDto = customersList.stream()
                .map(customer -> customerMapper.convertCustomerToCustomerDto(customer)) //przeanalizować możliwość wykorzystania referencji do metody
                .collect(Collectors.toList());
        Link link = WebMvcLinkBuilder.linkTo(CustomerController.class).withSelfRel();
        customersDto.forEach(customerDto -> customerDto.add(WebMvcLinkBuilder.linkTo(CustomerController.class).slash(customerDto.getId()).withSelfRel()));
        CollectionModel<CustomerDto> resource = new CollectionModel<>(customersDto, link);
        return new ResponseEntity(resource, HttpStatus.OK);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity deleteCustomer(@PathVariable Long customerId) {
        Long userId = userService.getCurrentLoggedUserId();
        customerService.deleteCustomer(userId, customerId);
        return new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping("/{customerId}")
    public ResponseEntity<EntityModel<CustomerDto>> getCustomer(@PathVariable Long customerId) {
        Link selfLink = WebMvcLinkBuilder.linkTo(CustomerController.class).slash(customerId).withSelfRel();
        Link customersLink = WebMvcLinkBuilder.linkTo(CustomerController.class).withRel("customers");
        Long userId = userService.getCurrentLoggedUserId();
        Customer customer = customerService.getCustomer(userId, customerId);
        CustomerDto customerDto = customerMapper.convertCustomerToCustomerDto(customer);
        EntityModel<CustomerDto> resource = new EntityModel<>(customerDto, selfLink, customersLink);
        return new ResponseEntity<>(resource, HttpStatus.OK);
    }


    @PatchMapping("/{customerId}")
    public ResponseEntity<EntityModel<CustomerDto>> updateCustomer(@PathVariable Long customerId, @RequestBody CustomerDto customerDto) {
        Long userId = userService.getCurrentLoggedUserId();
        Customer customerFromDto = customerMapper.convertCustomerDtoToCustomer(customerDto);
        Customer updatedCustomer = customerService.updateCustomer(userId, customerId, customerFromDto);
        CustomerDto updatedCustomerDto = customerMapper.convertCustomerToCustomerDto(updatedCustomer);
        Link selfLink = WebMvcLinkBuilder.linkTo(CustomerController.class).slash(updatedCustomerDto.getId()).withSelfRel();
        Link customersLink = WebMvcLinkBuilder.linkTo(CustomerController.class).withRel("customers");
        EntityModel<CustomerDto> resource = new EntityModel<>(updatedCustomerDto, selfLink, customersLink);
        return new ResponseEntity(resource, HttpStatus.OK);
    }

    @GetMapping("/{customerId}/devices")
    public ResponseEntity<CollectionModel<DeviceDto>> getAllCustomerDevices(@PathVariable Long customerId) {
        Long userId = userService.getCurrentLoggedUserId();
        List<Device> customerDevices = deviceService.findAllCustomerDevices(userId, customerId);
        List<DeviceDto> customerDevicesDto = customerDevices.stream()
                .map(device -> deviceMapper.convertDevicetoDeviceDto(device))
                .collect(Collectors.toList());
        customerDevicesDto.forEach(deviceDto -> deviceDto.add(WebMvcLinkBuilder.linkTo(CustomerController.class).slash(deviceDto.getId()).withSelfRel()));
        Link customersLink = WebMvcLinkBuilder.linkTo(CustomerController.class).withSelfRel();
        Link devicesLink = WebMvcLinkBuilder.linkTo(DeviceController.class).withSelfRel();
        CollectionModel<DeviceDto> resource = new CollectionModel<>(customerDevicesDto, customersLink, devicesLink);
        return new ResponseEntity<>(resource, HttpStatus.OK);
    }


    @GetMapping("/{customerId}/locations")
    public ResponseEntity<CollectionModel<LocationDto>> getAllCustomerLocations(@PathVariable Long customerId) {
        Long userId = userService.getCurrentLoggedUserId();
        List<Location> locationList =  locationService.findAllCustomersLocations(userId, customerId);
        List<LocationDto> locationDtos = locationList.stream()
                .map(location -> locationMapper.convertLocationToLocationDto(location))
                .collect(Collectors.toList());
        locationDtos.forEach(locationDto -> locationDto.add(WebMvcLinkBuilder.linkTo(CustomerController.class).slash(locationDto.getId()).withSelfRel()));
        Link customersLink = WebMvcLinkBuilder.linkTo(CustomerController.class).withRel("customers");
        Link locationsLink = WebMvcLinkBuilder.linkTo(LocationController.class).withRel("locations");
        CollectionModel<LocationDto> resource = new CollectionModel<>(locationDtos, customersLink, locationsLink);
        return new ResponseEntity(resource, HttpStatus.OK);
    }

    @GetMapping("/{customerId}/orders")
    public ResponseEntity<CollectionModel<OrderDto>> getAllCustomerOrders(@PathVariable Long customerId) {
        Long userId = userService.getCurrentLoggedUserId();
        List<Order> orderList =  orderService.findAllCustomersOrders(userId, customerId);
        List<OrderDto> orderDtos = orderList.stream()
                .map(order -> orderMapper.convertOrderToOrderDto(order))
                .collect(Collectors.toList());
        orderDtos.forEach(orderDto -> orderDto.add(WebMvcLinkBuilder.linkTo(CustomerController.class).slash(orderDto.getId()).withSelfRel()));
        Link customersLink = WebMvcLinkBuilder.linkTo(CustomerController.class).withRel("customers");
        Link ordersLink = WebMvcLinkBuilder.linkTo(OrderController.class).withRel("orders");
        CollectionModel<OrderDto> resource = new CollectionModel<>(orderDtos, customersLink, ordersLink);
        return new ResponseEntity(resource, HttpStatus.OK);
    }
}
