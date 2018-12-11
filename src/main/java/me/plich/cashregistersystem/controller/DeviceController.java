package me.plich.cashregistersystem.controller;

import com.fasterxml.jackson.annotation.JsonView;
import me.plich.cashregistersystem.model.Device;
import me.plich.cashregistersystem.model.Order;
import me.plich.cashregistersystem.model.View;
import me.plich.cashregistersystem.service.DeviceService;
import me.plich.cashregistersystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devices")
public class DeviceController {

    @Autowired
    DeviceService deviceService;
    @Autowired
    OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addDevice(@RequestBody Device device, @RequestHeader Long customerID, @RequestHeader Long locationID) {
        deviceService.addDevice(device, customerID, locationID);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @JsonView(View.Public.class)
    public @ResponseBody  List<Device> getAllUserDevices() {
        return deviceService.getAllUserDevices();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDevice(@PathVariable Long id) {
        deviceService.deleteDevice(id);
    }

    @JsonView(View.Public.class)
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Device getDevice(@PathVariable Long id) {
        return deviceService.getDevice(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDevice(@PathVariable Long id, @RequestBody Device device) {
        deviceService.updateDevice(id, device);
    }

    @JsonView(View.Public.class)
    @GetMapping("/{id}/orders")
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getDeviceOrders(@PathVariable Long id) {
        return orderService.getDeviceOrders(id);
    }

    @GetMapping("/advanced")
    @ResponseStatus(HttpStatus.OK)
    public List<Device> findAllByRsql(@RequestParam(value = "search") String search) {
        return deviceService.findAllByRsql(search);
    }




}
