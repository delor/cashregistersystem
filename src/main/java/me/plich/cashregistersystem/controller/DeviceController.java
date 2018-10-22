package me.plich.cashregistersystem.controller;

import com.fasterxml.jackson.annotation.JsonView;
import me.plich.cashregistersystem.model.Device;
import me.plich.cashregistersystem.model.View;
import me.plich.cashregistersystem.service.DeviceSercive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    DeviceSercive deviceService;

    @PostMapping
    public void addDevice(@RequestBody Device device, @RequestHeader Long userID, @RequestHeader Long customerID, @RequestHeader Long locationID) {
        deviceService.addDevice(device, userID, customerID, locationID);
    }
    @GetMapping
    @JsonView(View.Public.class)
    public List<Device> getAllDevices() {
        return deviceService.getAllDevices();
    }

    @DeleteMapping("/device/{id}")
    public void deleteDevice(@PathVariable Long id) {
        deviceService.deleteDevice(id);
    }
    @JsonView(View.Public.class)
    @GetMapping("/device/{id}")
    public Device getDevice(@PathVariable Long id) {
        return deviceService.getDevice(id);
    }
}
