package me.plich.cashregistersystem.controller;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.plich.cashregistersystem.exception.ResourceNotFoundException;
import me.plich.cashregistersystem.model.Device;
import me.plich.cashregistersystem.model.Order;
import me.plich.cashregistersystem.model.View;
import me.plich.cashregistersystem.service.DeviceService;
import me.plich.cashregistersystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devices")
@Api(description = "Set of endpoints for Creating, Retrieving, Updating and Deleting of devices.")
public class DeviceController {

    @Autowired
    DeviceService deviceService;
    @Autowired
    OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Creates new device")
    public void addDevice(@RequestBody Device device, @RequestHeader Long customerID, @RequestHeader Long locationID) {
        deviceService.addDevice(device, customerID, locationID);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @JsonView(View.Public.class)
    @ApiOperation("Returns list of all user devices")
    public @ResponseBody  List<Device> getAllUserDevices() {
        return deviceService.getAllUserDevices();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Deletes devices with a specific id from system")
    public void deleteDevice(@PathVariable Long id) {
        deviceService.deleteDevice(id);
    }

    @JsonView(View.Public.class)
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation("Returns a device with a specific id")
    public ResponseEntity<Device> getDevice(@PathVariable Long id) throws  ResourceNotFoundException {

            Device device = deviceService.getDevice(id);
            if(device == null) {
                throw new ResourceNotFoundException("Device", "this ID", device);
            }
            else  {
                return ResponseEntity.status(HttpStatus.OK).body(device);
            }
        }


    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Updates the device with a specific id")
    public void updateDevice(@PathVariable Long id, @RequestBody Device device) {
        deviceService.updateDevice(id, device);
    }

    @JsonView(View.Public.class)
    @GetMapping("/{id}/orders")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Returns list of orders for device with a specific id")
    public List<Order> getDeviceOrders(@PathVariable Long id) {
        return orderService.getDeviceOrders(id);
    }






}
