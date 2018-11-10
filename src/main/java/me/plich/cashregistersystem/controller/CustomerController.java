package me.plich.cashregistersystem.controller;

import com.fasterxml.jackson.annotation.JsonView;
import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import me.plich.cashregistersystem.config.rsql.CustomRsqlVisitor;
import me.plich.cashregistersystem.model.Customer;
import me.plich.cashregistersystem.model.Device;
import me.plich.cashregistersystem.model.Location;
import me.plich.cashregistersystem.model.View;

import me.plich.cashregistersystem.service.CustomerService;
import me.plich.cashregistersystem.service.DeviceService;
import me.plich.cashregistersystem.service.LocationService;
import me.plich.cashregistersystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    UserService userService;
    @Autowired
    DeviceService deviceService;
    @Autowired
    LocationService locationService;

    @PostMapping
    public void addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }

    @GetMapping
    @JsonView(View.Public.class)
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

    @JsonView(View.Public.class)
    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }

    @GetMapping("/advanced")
    public List<Customer> findAllByRsql(@RequestParam(value = "search") String search) {
       return customerService.findAllByRsql(search);
    }

    @PatchMapping("/{id}")
    public void updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        customerService.updateCustomer(id, customer);
    }

    @GetMapping("/{id}/devices")
    @JsonView(View.Public.class)
    public @ResponseBody List<Device> getAllCustomerDevices(@PathVariable Long id) {
        return deviceService.getAllCustomerDevices(id);
    }

    @GetMapping("/{id}/locations")
    @JsonView(View.Public.class)
    public List<Location> getAllCustomerLocations(@PathVariable Long id) {
        return locationService.getAllCustomerLocations(id);
    }


}
