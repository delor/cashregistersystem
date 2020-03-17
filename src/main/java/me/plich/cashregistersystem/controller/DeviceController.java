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
@RequestMapping("/devices")
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


    @PostMapping
    public ResponseEntity<EntityModel<DeviceDto>> addDevice(@RequestBody DeviceDto deviceDto, @RequestHeader Long customerId,@RequestHeader Long producerId,@RequestHeader Long modelId, @RequestHeader Long locationId) {
        Long userId = userService.getCurrentLoggedUserId();
        System.out.println("locationId = "+locationId);
        Device deviceFromDto = deviceMapper.convertDeviceDtoToDevice(deviceDto);
        Device createdDevice = deviceService.addDevice(userId, deviceFromDto, customerId, producerId, modelId, locationId);
        DeviceDto createdDeviceDto = deviceMapper.convertDevicetoDeviceDto(createdDevice);
        Link selfLink = WebMvcLinkBuilder.linkTo(CustomerController.class).slash(createdDeviceDto.getId()).withSelfRel();
        Link devicesLink = WebMvcLinkBuilder.linkTo(DeviceController.class).withRel("devices");
        EntityModel<DeviceDto> resource = new EntityModel<>(createdDeviceDto, selfLink, devicesLink);
        return new ResponseEntity(resource, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<CollectionModel<DeviceDto>> getAllUserDevices() {
        Long userId = userService.getCurrentLoggedUserId();
        List<Device> devices = deviceService.findAllUserDevices(userId);
        List<DeviceDto> deviceDtos = devices.stream()
                .map(device -> deviceMapper.convertDevicetoDeviceDto(device))
                .collect(Collectors.toList());
        Link link = WebMvcLinkBuilder.linkTo(CustomerController.class).withSelfRel();
        deviceDtos.forEach(deviceDto -> deviceDto.add(WebMvcLinkBuilder.linkTo(CustomerController.class).slash(deviceDto.getId()).withSelfRel()));
        CollectionModel<DeviceDto> resource = new CollectionModel<>(deviceDtos, link);
        return new ResponseEntity(resource, HttpStatus.OK);
    }

    @DeleteMapping("/{deviceId}")
    public ResponseEntity deleteDevice(@PathVariable Long deviceId) {
        Long userId = userService.getCurrentLoggedUserId();
        deviceService.deleteDevice(userId, deviceId);
        return new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping("/{deviceId}")
    public ResponseEntity<EntityModel<DeviceDto>> getDevice(@PathVariable Long deviceId) {
        Long userId = userService.getCurrentLoggedUserId();
        Device device = deviceService.getDevice(userId, deviceId);
        DeviceDto deviceDto = deviceMapper.convertDevicetoDeviceDto(device);
        Link selfLink = WebMvcLinkBuilder.linkTo(CustomerController.class).slash(deviceId).withSelfRel();
        Link devicesLink = WebMvcLinkBuilder.linkTo(DeviceController.class).withRel("devices");
        EntityModel<DeviceDto> resource = new EntityModel<>(deviceDto, selfLink, devicesLink);
        return new ResponseEntity<>(resource, HttpStatus.OK);
    }



    @PatchMapping("/{devicesId}")
    public ResponseEntity<EntityModel<DeviceDto>> updateDevice(@PathVariable Long devicesId, @RequestBody DeviceDto deviceDto) {
        Long userId = userService.getCurrentLoggedUserId();
        Device deviceFromDto = deviceMapper.convertDeviceDtoToDevice(deviceDto);
        Device updatedDevice = deviceService.updateDevice(userId, devicesId, deviceFromDto);
        DeviceDto updatedDeviceDto = deviceMapper.convertDevicetoDeviceDto(updatedDevice);
        Link selfLink = WebMvcLinkBuilder.linkTo(DeviceController.class).slash(updatedDeviceDto.getId()).withSelfRel();
        Link devicesLink = WebMvcLinkBuilder.linkTo(DeviceController.class).withRel("devices");
        EntityModel<DeviceDto> resource = new EntityModel<>(updatedDeviceDto, selfLink, devicesLink);
        return new ResponseEntity(resource, HttpStatus.OK);
    }

    @GetMapping("/{devicesId}/orders")
    public ResponseEntity<CollectionModel<OrderDto>> getAllDeviceOrders(@PathVariable Long devicesId) {
        Long userId = userService.getCurrentLoggedUserId();
        List<Order> orderList =  orderService.findAllDevicesOrders(userId, devicesId);
        List<OrderDto> orderDtos = orderList.stream()
                .map(order -> orderMapper.convertOrderToOrderDto(order))
                .collect(Collectors.toList());
        orderDtos.forEach(orderDto -> orderDto.add(WebMvcLinkBuilder.linkTo(LocationController.class).slash(orderDto.getId()).withSelfRel()));
        Link ordersLink = WebMvcLinkBuilder.linkTo(LocationController.class).withRel("orders");
        Link devicesLink = WebMvcLinkBuilder.linkTo(DeviceController.class).withRel("devices");
        CollectionModel<OrderDto> resource = new CollectionModel<>(orderDtos, ordersLink, devicesLink);
        return new ResponseEntity(resource, HttpStatus.OK);
    }

    @GetMapping("/{devicesId}/locations")
    public ResponseEntity<EntityModel<LocationDto>> getDevicesLocations(@PathVariable Long devicesId) {
        Long userId = userService.getCurrentLoggedUserId();
        Location location =  locationService.getDevicesLocation(userId, devicesId);
        LocationDto locationDto = locationMapper.convertLocationToLocationDto(location);
        Link link = WebMvcLinkBuilder.linkTo(DeviceController.class).slash(devicesId).withSelfRel();
        Link locationsLink = WebMvcLinkBuilder.linkTo(LocationController.class).withRel("locations");
        Link devicesLink = WebMvcLinkBuilder.linkTo(DeviceController.class).withRel("devices");
        EntityModel<LocationDto> resource = new EntityModel<>(locationDto, link, devicesLink, locationsLink);
        return new ResponseEntity<>(resource, HttpStatus.OK);
    }

    @PostMapping("/{devicesId}/locations")
    public ResponseEntity<EntityModel<LocationDto>> setDevicesLocation(@PathVariable Long devicesId, @RequestHeader Long locationId) {
        Long userId = userService.getCurrentLoggedUserId();
        Location location =  locationService.setDevicesLocation(userId, devicesId, locationId);
        LocationDto locationDto = locationMapper.convertLocationToLocationDto(location);
        Link link = WebMvcLinkBuilder.linkTo(DeviceController.class).slash(devicesId).withSelfRel();
        Link devicesLink = WebMvcLinkBuilder.linkTo(DeviceController.class).withRel("devices");
        EntityModel<LocationDto> resource = new EntityModel<>(locationDto, link, devicesLink);
        return new ResponseEntity<>(resource, HttpStatus.OK);
    }

    @GetMapping("/{devicesId}/customers")
    public ResponseEntity<EntityModel<CustomerDto>> getDevicesCustomer(@PathVariable Long devicesId) {
        Long userId = userService.getCurrentLoggedUserId();
        Customer customer =  customerService.getDevicesCustomer(userId, devicesId);
        CustomerDto customerDto = customerMapper.convertCustomerToCustomerDto(customer);
        Link link = WebMvcLinkBuilder.linkTo(DeviceController.class).slash(devicesId).withSelfRel();
        Link customersLink = WebMvcLinkBuilder.linkTo(CustomerController.class).withRel("customers");
        Link devicesLink = WebMvcLinkBuilder.linkTo(DeviceController.class).withRel("devices");
        EntityModel<CustomerDto> resource = new EntityModel<>(customerDto, link, devicesLink, customersLink);
        return new ResponseEntity<>(resource, HttpStatus.OK);
    }

    @PutMapping("/{devicesId}/set-mobile-command")
    public ResponseEntity setMobile(@PathVariable Long devicesId) {
        Long userId = userService.getCurrentLoggedUserId();
        deviceService.setMobile(userId, devicesId);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

}
