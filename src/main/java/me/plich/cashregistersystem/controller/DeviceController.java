package me.plich.cashregistersystem.controller;

import com.fasterxml.jackson.annotation.JsonView;
import me.plich.cashregistersystem.model.Device;
import me.plich.cashregistersystem.model.Order;
import me.plich.cashregistersystem.model.View;
import me.plich.cashregistersystem.service.DeviceService;
import me.plich.cashregistersystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    DeviceService deviceService;
    @Autowired
    OrderService orderService;

    @PostMapping
    public void addDevice(@RequestBody Device device, @RequestHeader Long customerID, @RequestHeader Long locationID) {
        deviceService.addDevice(device, customerID, locationID);
    }
    @GetMapping
    @JsonView(View.Public.class)
    public List<Device> getAllUserDevices() {
        return deviceService.getAllUserDevices();
    }

    @DeleteMapping("/{id}")
    public void deleteDevice(@PathVariable Long id) {
        deviceService.deleteDevice(id);
    }

    @JsonView(View.Public.class)
    @GetMapping("/{id}")
    public Device getDevice(@PathVariable Long id) {
        return deviceService.getDevice(id);
    }

    @PatchMapping("/{id}")
    public void updateDevice(@PathVariable Long id, @RequestBody Device device) {
        deviceService.updateDevice(id, device);
    }

    @JsonView(View.Public.class)
    @GetMapping("/{id}/orders")
    public List<Order> getDeviceOrders(@PathVariable Long id) {
        return getDeviceOrders(id);
    }

}
