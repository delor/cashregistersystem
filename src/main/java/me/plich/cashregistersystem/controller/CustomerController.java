package me.plich.cashregistersystem.controller;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiOperation;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
@ApiOperation("Set of endpoints for Creating, Retrieving, Updating and Deleting of customers.")
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
    @JsonView(View.Public.class)
    @ApiOperation("Create new customer")
    public ResponseEntity<CustomerDto> addCustomer(@RequestBody CustomerDto customerDto) {
        Long userId = userService.getCurrentLoggedUserId();
        Customer customerFromDto = customerMapper.convertCustomerDtoToCustomer(customerDto);
        Customer createdCustomer = customerService.addCustomer(userId, customerFromDto);
        CustomerDto createdCustomerDto = customerMapper.convertCustomerToCustomerDto(createdCustomer);
        return new ResponseEntity(createdCustomerDto, HttpStatus.CREATED);
    }

    @GetMapping
    @JsonView(View.Public.class)
    @ApiOperation("Returns list of customers")
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        Long userId = userService.getCurrentLoggedUserId();
        List<Customer> customersList = customerService.getAllCustomers(userId);
        List<CustomerDto> customersDto = customersList.stream()
                .map(customer -> customerMapper.convertCustomerToCustomerDto(customer)) //przeanalizować możliwość wykorzystania referencji do metody
                .collect(Collectors.toList());
        return new ResponseEntity(customersDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Deletes customer with a specific id")
    public ResponseEntity deleteCustomer(@PathVariable Long customerId) {
        Long userId = userService.getCurrentLoggedUserId();
        customerService.deleteCustomer(userId, customerId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @JsonView(View.Public.class)
    @GetMapping("/{id}")
    @ApiOperation("Returns customer with specific id")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable Long customerId) {
        Long userId = userService.getCurrentLoggedUserId();
        Customer customer = customerService.getCustomer(userId, customerId);
        CustomerDto customerDto = customerMapper.convertCustomerToCustomerDto(customer);
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }


    @PatchMapping("/{id}")
    @ApiOperation("Updates the customer with a specific id")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable Long customerId, @RequestBody CustomerDto customerDto) {
        Long userId = userService.getCurrentLoggedUserId();
        Customer customerFromDto = customerMapper.convertCustomerDtoToCustomer(customerDto);
        Customer updatedCustomer = customerService.updateCustomer(userId, customerId, customerFromDto);
        CustomerDto updatedCustomerDto = customerMapper.convertCustomerToCustomerDto(updatedCustomer);
        return new ResponseEntity(updatedCustomerDto, HttpStatus.OK);
    }

    @GetMapping("/{id}/devices")
    @JsonView(View.Public.class)
    @ApiOperation("Returns the list of customer devices with a specified id")
    public ResponseEntity<List<DeviceDto>> getAllCustomerDevices(@PathVariable Long customerId) {
        Long userId = userService.getCurrentLoggedUserId();
        List<Device> customerDevices = deviceService.findAllCustomerDevices(userId, customerId);
        List<DeviceDto> customerDevicesDto = customerDevices.stream()
                .map(device -> deviceMapper.convertDevicetoDeviceDto(device))
                .collect(Collectors.toList());
        return new ResponseEntity<>(customerDevicesDto, HttpStatus.OK);
    }


    @GetMapping("/{id}/locations")
    @JsonView(View.Public.class)
    @ApiOperation("Returns the list of customer locations with a specified id")
    public ResponseEntity<List<LocationDto>> getAllCustomerLocations(@PathVariable Long customerId) {
        Long userId = userService.getCurrentLoggedUserId();
        List<Location> locationList =  locationService.findAllCustomersLocations(userId, customerId);
        List<LocationDto> locationDtos = locationList.stream()
                .map(location -> locationMapper.convertLocationToLocationDto(location))
                .collect(Collectors.toList());
        return new ResponseEntity(locationDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}/orders")
    @JsonView(View.Public.class)
    @ApiOperation("Returns the list of customer orders with a specified id")
    public ResponseEntity<List<OrderDto>> getAllCustomerOrders(@PathVariable Long customerId) {
        Long userId = userService.getCurrentLoggedUserId();
        List<Order> orderList =  orderService.findAllCustomersOrders(userId, customerId);
        List<OrderDto> orderDtos = orderList.stream()
                .map(order -> orderMapper.convertOrderToOrderDto(order))
                .collect(Collectors.toList());
        return new ResponseEntity(orderDtos, HttpStatus.OK);
    }


}
