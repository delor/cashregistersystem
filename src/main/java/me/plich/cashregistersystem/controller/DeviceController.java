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
@RequestMapping("/devices")
@ApiOperation("Set of endpoints for Creating, Retrieving, Updating and Deleting of devices.")
public class DeviceController {


    private IDeviceService deviceService;
    private IOrderService orderService;
    private IUserService userService;
    private ICustomerService customerService;
    private ILocationService locationService;
    private DeviceMapper deviceMapper;
    private OrderMapper orderMapper;
    private LocationMapper locationMapper;
    private CustomerMapper customerMapper;

    @Autowired
    public DeviceController(@Qualifier("deviceService")IDeviceService deviceService,
                            @Qualifier("orderService")IOrderService orderService,
                            @Qualifier("userService") IUserService userService,
                            @Qualifier("locationService") ILocationService locationService,
                            @Qualifier("customerService") ICustomerService customerService,
                            DeviceMapper deviceMapper,
                            LocationMapper locationMapper,
                            OrderMapper orderMapper,
                            CustomerMapper customerMapper) {
        this.deviceService = deviceService;
        this.orderService = orderService;
        this.userService = userService;
        this.deviceMapper = deviceMapper;
        this.orderMapper = orderMapper;
        this.locationService = locationService;
        this.locationMapper = locationMapper;
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @JsonView(View.Public.class)
    @PostMapping
    @ApiOperation("Creates new device")
    public ResponseEntity<DeviceDto> addDevice(@RequestBody DeviceDto deviceDto, @RequestHeader Long customerId) {
        Long userId = userService.getCurrentLoggedUserId();
        Device deviceFromDto = deviceMapper.convertDeviceDtoToDevice(deviceDto);
        Device createdDevice = deviceService.addDevice(userId, deviceFromDto, customerId);
        DeviceDto createdDeviceDto = deviceMapper.convertDevicetoDeviceDto(createdDevice);
        return new ResponseEntity<>(createdDeviceDto, HttpStatus.CREATED);
    }

    @GetMapping
    @JsonView(View.Public.class)
    @ApiOperation("Returns list of all user devices")
    public ResponseEntity<List<DeviceDto>> getAllUserDevices() {
        Long userId = userService.getCurrentLoggedUserId();
        List<Device> devices = deviceService.findAllUserDevices(userId);
        List<DeviceDto> deviceDtos = devices.stream()
                .map(device -> deviceMapper.convertDevicetoDeviceDto(device))
                .collect(Collectors.toList());
        return new ResponseEntity(deviceDtos, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Deletes device with a specific id")
    public ResponseEntity deleteDevice(@PathVariable Long deviceId) {
        Long userId = userService.getCurrentLoggedUserId();
        deviceService.deleteDevice(userId, deviceId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @JsonView(View.Public.class)
    @GetMapping("/{id}")
    @ApiOperation("Returns a device with a specific id")
    public ResponseEntity<DeviceDto> getDevice(@PathVariable Long deviceId) {
        Long userId = userService.getCurrentLoggedUserId();
        Device device = deviceService.getDevice(userId, deviceId);
        DeviceDto deviceDto = deviceMapper.convertDevicetoDeviceDto(device);
        return new ResponseEntity(deviceDto, HttpStatus.OK);
    }


    @JsonView(View.Public.class)
    @PatchMapping("/{id}")
    @ApiOperation("Updates the device with a specific id")
    public ResponseEntity<DeviceDto> updateDevice(@PathVariable Long deviceId, @RequestBody DeviceDto deviceDto) {
        Long userId = userService.getCurrentLoggedUserId();
        Device deviceFromDto = deviceMapper.convertDeviceDtoToDevice(deviceDto);
        Device updatedDevice = deviceService.updateDevice(userId, deviceId, deviceFromDto);
        DeviceDto updatedDeviceDto = deviceMapper.convertDevicetoDeviceDto(updatedDevice);
        return new ResponseEntity(updatedDeviceDto, HttpStatus.OK);
    }

    @GetMapping("/{id}/orders")
    @JsonView(View.Public.class)
    @ApiOperation("Returns the list of devices orders with a specified id")
    public ResponseEntity<List<OrderDto>> getAllDeviceOrders(@PathVariable Long deviceId) {
        Long userId = userService.getCurrentLoggedUserId();
        List<Order> orderList =  orderService.findAllDevicesOrders(userId, deviceId);
        List<OrderDto> orderDtos = orderList.stream()
                .map(order -> orderMapper.convertOrderToOrderDto(order))
                .collect(Collectors.toList());
        return new ResponseEntity(orderDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}/locations")
    @JsonView(View.Public.class)
    @ApiOperation("Returns device location with a specified id")
    public ResponseEntity<LocationDto> getDevicesLocations(@PathVariable Long devicesId) {
        Long userId = userService.getCurrentLoggedUserId();
        Location location =  locationService.getDevicesLocation(userId, devicesId);
        LocationDto locationDto = locationMapper.convertLocationToLocationDto(location);
        return new ResponseEntity(locationDto, HttpStatus.OK);
    }

    @GetMapping("/{id}/customers")
    @JsonView(View.Public.class)
    @ApiOperation("Returns devices customer")
    public ResponseEntity<CustomerDto> getDevicesCustomer(@PathVariable Long devicesId) {
        Long userId = userService.getCurrentLoggedUserId();
        Customer customer =  customerService.getDevicesCustomer(userId, devicesId);
        CustomerDto customernDto = customerMapper.convertCustomerToCustomerDto(customer);
        return new ResponseEntity(customernDto, HttpStatus.OK);
    }

}
