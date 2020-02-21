package me.plich.cashregistersystem.controller;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.plich.cashregistersystem.model.Customer;
import me.plich.cashregistersystem.model.Device;
import me.plich.cashregistersystem.model.Location;
import me.plich.cashregistersystem.model.View;
import me.plich.cashregistersystem.service.CustomerService;
import me.plich.cashregistersystem.service.DeviceService;
import me.plich.cashregistersystem.service.LocationService;
import me.plich.cashregistersystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/customers")
@Api(description = "Set of endpoints for Creating, Retrieving, Updating and Deleting of customers.")
public class CustomerController {


    private CustomerService customerService;
    private UserService userService;
    private DeviceService deviceService;
    private LocationService locationService;

    @Autowired
    public CustomerController(CustomerService customerService, UserService userService, DeviceService deviceService, LocationService locationService) {
        this.customerService = customerService;
        this.userService = userService;
        this.deviceService = deviceService;
        this.locationService = locationService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Creates new customer")
    public void addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @JsonView(View.Public.class)
    @ApiOperation("Returns list of customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Deletes customer with a specific id from system")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

    @JsonView(View.Public.class)
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Returns customer with specific id")
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }


    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Updates the customer with a specific id")
    public void updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        customerService.updateCustomer(id, customer);
    }

    @GetMapping("/{id}/devices")
    @ResponseStatus(HttpStatus.OK)
    @JsonView(View.Public.class)
    @ApiOperation("Returns the list of customer devices with a specified id")
    public @ResponseBody List<Device> getAllCustomerDevices(@PathVariable Long id) {
        return deviceService.getAllCustomerDevices(id);
    }

    @GetMapping("/{id}/locations")
    @ResponseStatus(HttpStatus.OK)
    @JsonView(View.Public.class)
    @ApiOperation("Returns the list of customer locations with a specified id")
    public List<Location> getAllCustomerLocations(@PathVariable Long id) {
        return locationService.getAllCustomerLocations(id);
    }


}
