package me.plich.cashregistersystem.controller;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiOperation;
import me.plich.cashregistersystem.dto.CustomerDto;
import me.plich.cashregistersystem.dto.DeviceDto;
import me.plich.cashregistersystem.dto.LocationDto;
import me.plich.cashregistersystem.mapper.CustomerMapper;
import me.plich.cashregistersystem.mapper.DeviceMapper;
import me.plich.cashregistersystem.mapper.LocationMapper;
import me.plich.cashregistersystem.model.Customer;
import me.plich.cashregistersystem.model.Device;
import me.plich.cashregistersystem.model.Location;
import me.plich.cashregistersystem.model.View;
import me.plich.cashregistersystem.service.ICustomerService;
import me.plich.cashregistersystem.service.IDeviceService;
import me.plich.cashregistersystem.service.ILocationService;
import me.plich.cashregistersystem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/locations")
@ApiOperation("Set of endpoints for Creating, Retrieving, Updating and Deleting of locations.")
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
    @JsonView(View.Public.class)
    @ApiOperation("Creates new location")
    public ResponseEntity<LocationDto> addLocation(@RequestBody LocationDto locationDto, @RequestHeader Long customerId) {
        Long userId = userService.getCurrentLoggedUserId();
        Location locationFromDto = locationMapper.convertLocationDtoToLocation(locationDto);
        Location createdLocation = locationService.addLocation(userId, locationFromDto, customerId);
        LocationDto createdLocationDto = locationMapper.convertLocationToLocationDto(createdLocation);
        return new ResponseEntity(createdLocationDto, HttpStatus.CREATED);

    }

    @GetMapping
    @JsonView(View.Public.class)
    @ApiOperation("Returns list of all users locations")
    public ResponseEntity<List<LocationDto>> getAllUserLocations() {
        Long userId = userService.getCurrentLoggedUserId();
        List<Location> locationsList = locationService.getAllLocations(userId);
        List<LocationDto> locationsDto = locationsList.stream()
                .map(location -> locationMapper.convertLocationToLocationDto(location)) //przeanalizować możliwość wykorzystania referencji do metody
                .collect(Collectors.toList());
        return new ResponseEntity(locationsDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Deletes location with a specific id from system")
    public ResponseEntity deleteLocation(@PathVariable Long locationId) {
        Long userId = userService.getCurrentLoggedUserId();
        locationService.deleteLocation(userId, locationId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Returns a location with a specific id")
    public ResponseEntity<LocationDto> getLocation(@PathVariable Long locationId) {
        Long userId = userService.getCurrentLoggedUserId();
        Location location = locationService.getLocation(userId, locationId);
        LocationDto locationDto = locationMapper.convertLocationToLocationDto(location);
        return new ResponseEntity<>(locationDto, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    @ApiOperation("Update the location with a specific id")
    public ResponseEntity<LocationDto> updateLocation(@PathVariable Long locationId, @RequestBody LocationDto locationDto) {
        Long userId = userService.getCurrentLoggedUserId();
        Location locationFromDto = locationMapper.convertLocationDtoToLocation(locationDto);
        Location updatedLocation = locationService.updateLocation(userId, locationId, locationFromDto);
        LocationDto updatedLocationDto = locationMapper.convertLocationToLocationDto(updatedLocation);
        return new ResponseEntity(updatedLocationDto, HttpStatus.OK);
    }

    @GetMapping("/{id}/devices")
    @JsonView(View.Public.class)
    @ApiOperation("Returns the list of locations devices with a specified id")
    public ResponseEntity<List<DeviceDto>> getAllLocationsDevices(@PathVariable Long locationId) {
        Long userId = userService.getCurrentLoggedUserId();
        List<Device> locationsDevices = deviceService.findAllLocationsDevices(userId, locationId);
        List<DeviceDto> locationsDevicesDto = locationsDevices.stream()
                .map(device -> deviceMapper.convertDevicetoDeviceDto(device))
                .collect(Collectors.toList());
        return new ResponseEntity<>(locationsDevicesDto, HttpStatus.OK);
    }

    @GetMapping("/{id}/customers")
    @JsonView(View.Public.class)
    @ApiOperation("Returns locations customer")
    public ResponseEntity<CustomerDto> getLocationsCustomer(@PathVariable Long locationId) {
        Long userId = userService.getCurrentLoggedUserId();
        Customer customer =  customerService.getLocationsCustomer(userId, locationId);
        CustomerDto customerDto = customerMapper.convertCustomerToCustomerDto(customer);
        return new ResponseEntity(customerDto, HttpStatus.OK);
    }
}
