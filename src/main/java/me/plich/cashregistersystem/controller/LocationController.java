package me.plich.cashregistersystem.controller;

import me.plich.cashregistersystem.dto.CustomerDto;
import me.plich.cashregistersystem.dto.DeviceDto;
import me.plich.cashregistersystem.dto.LocationDto;
import me.plich.cashregistersystem.mapper.CustomerMapper;
import me.plich.cashregistersystem.mapper.DeviceMapper;
import me.plich.cashregistersystem.mapper.LocationMapper;
import me.plich.cashregistersystem.model.Customer;
import me.plich.cashregistersystem.model.Device;
import me.plich.cashregistersystem.model.Location;
import me.plich.cashregistersystem.service.ICustomerService;
import me.plich.cashregistersystem.service.IDeviceService;
import me.plich.cashregistersystem.service.ILocationService;
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
@RequestMapping("/locations")
public class LocationController {


    private ILocationService locationService;
    private IDeviceService deviceService;
    private IUserService userService;
    private ICustomerService customerService;
    private LocationMapper locationMapper;
    private DeviceMapper deviceMapper;
    private CustomerMapper customerMapper;

    @Autowired
    public LocationController(@Qualifier("locationService")ILocationService locationService,
                              @Qualifier("deviceService")IDeviceService deviceService,
                              @Qualifier("userService") IUserService userService,
                              @Qualifier("customerService") ICustomerService customerService,
                              LocationMapper locationMapper,
                              CustomerMapper customerMapper,
                              DeviceMapper deviceMapper) {
        this.locationService = locationService;
        this.deviceService = deviceService;
        this.userService = userService;
        this.customerService = customerService;
        this.locationMapper = locationMapper;
        this.deviceMapper = deviceMapper;
        this.customerMapper = customerMapper;
    }

    @PostMapping
    public ResponseEntity<EntityModel<LocationDto>> addLocation(@RequestBody LocationDto locationDto, @RequestHeader Long customerId) {
        Long userId = userService.getCurrentLoggedUserId();
        Location locationFromDto = locationMapper.convertLocationDtoToLocation(locationDto);
        Location createdLocation = locationService.addLocation(userId, locationFromDto, customerId);
        LocationDto createdLocationDto = locationMapper.convertLocationToLocationDto(createdLocation);
        Link selfLink = WebMvcLinkBuilder.linkTo(CustomerController.class).slash(createdLocationDto.getId()).withSelfRel();
        Link locationsLink = WebMvcLinkBuilder.linkTo(LocationController.class).withRel("locations");
        EntityModel<LocationDto> resource = new EntityModel<>(createdLocationDto, selfLink, locationsLink);
        return new ResponseEntity(resource, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<CollectionModel<LocationDto>> getAllUserLocations() {
        Long userId = userService.getCurrentLoggedUserId();
        List<Location> locationsList = locationService.getAllLocations(userId);
        List<LocationDto> locationsDto = locationsList.stream()
                .map(location -> locationMapper.convertLocationToLocationDto(location)) //przeanalizować możliwość wykorzystania referencji do metody
                .collect(Collectors.toList());
        Link link = WebMvcLinkBuilder.linkTo(LocationController.class).withSelfRel();
        locationsDto.forEach(locationDto -> locationDto.add(WebMvcLinkBuilder.linkTo(LocationController.class).slash(locationDto.getId()).withSelfRel()));
        CollectionModel<LocationDto> resource = new CollectionModel<>(locationsDto, link);
        return new ResponseEntity(resource, HttpStatus.OK);
    }

    @DeleteMapping("/{locationId}")
    public ResponseEntity deleteLocation(@PathVariable Long locationId) {
        Long userId = userService.getCurrentLoggedUserId();
        locationService.deleteLocation(userId, locationId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{locationId}")
    public ResponseEntity<EntityModel<LocationDto>> getLocation(@PathVariable Long locationId) {
        Long userId = userService.getCurrentLoggedUserId();
        Location location = locationService.getLocation(userId, locationId);
        LocationDto locationDto = locationMapper.convertLocationToLocationDto(location);
        Link selfLink = WebMvcLinkBuilder.linkTo(LocationController.class).slash(locationId).withSelfRel();
        Link locationsLink = WebMvcLinkBuilder.linkTo(LocationController.class).withRel("locations");
        EntityModel<LocationDto> resource = new EntityModel<>(locationDto, selfLink, locationsLink);
        return new ResponseEntity<>(resource, HttpStatus.OK);
    }

    @PatchMapping("/{locationId}")
    public ResponseEntity<LocationDto> updateLocation(@PathVariable Long locationId, @RequestBody LocationDto locationDto) {
        Long userId = userService.getCurrentLoggedUserId();
        Location locationFromDto = locationMapper.convertLocationDtoToLocation(locationDto);
        Location updatedLocation = locationService.updateLocation(userId, locationId, locationFromDto);
        LocationDto updatedLocationDto = locationMapper.convertLocationToLocationDto(updatedLocation);
        Link selfLink = WebMvcLinkBuilder.linkTo(LocationController.class).slash(updatedLocationDto.getId()).withSelfRel();
        Link locationsLink = WebMvcLinkBuilder.linkTo(LocationController.class).withRel("locations");
        EntityModel<LocationDto> resource = new EntityModel<>(updatedLocationDto, selfLink, locationsLink);
        return new ResponseEntity(resource, HttpStatus.OK);
    }

    @GetMapping("/{locationId}/devices")
    public ResponseEntity<CollectionModel<DeviceDto>> getAllLocationsDevices(@PathVariable Long locationId) {
        Long userId = userService.getCurrentLoggedUserId();
        List<Device> locationsDevices = deviceService.findAllLocationsDevices(userId, locationId);
        List<DeviceDto> locationsDevicesDto = locationsDevices.stream()
                .map(device -> deviceMapper.convertDevicetoDeviceDto(device))
                .collect(Collectors.toList());
        locationsDevicesDto.forEach(locationDto -> locationDto.add(WebMvcLinkBuilder.linkTo(LocationController.class).slash(locationDto.getId()).withSelfRel()));
        Link locationsLink = WebMvcLinkBuilder.linkTo(LocationController.class).withRel("locations");
        Link devicesLink = WebMvcLinkBuilder.linkTo(DeviceController.class).withRel("devices");
        CollectionModel<DeviceDto> resource = new CollectionModel<>(locationsDevicesDto, locationsLink, devicesLink);
        return new ResponseEntity(resource, HttpStatus.OK);
    }

    @GetMapping("/{locationId}/customers")
    public ResponseEntity<EntityModel<CustomerDto>> getLocationsCustomer(@PathVariable Long locationId) {
        Long userId = userService.getCurrentLoggedUserId();
        Customer customer =  customerService.getLocationsCustomer(userId, locationId);
        CustomerDto customerDto = customerMapper.convertCustomerToCustomerDto(customer);
        Link link = WebMvcLinkBuilder.linkTo(LocationController.class).slash(locationId).withSelfRel();
        Link customersLink = WebMvcLinkBuilder.linkTo(CustomerController.class).withRel("customers");
        Link locationsLink = WebMvcLinkBuilder.linkTo(LocationController.class).withRel("locations");
        EntityModel<CustomerDto> resource = new EntityModel<>(customerDto, link, locationsLink, customersLink);
        return new ResponseEntity<>(resource, HttpStatus.OK);
    }
}
