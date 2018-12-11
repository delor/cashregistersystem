package me.plich.cashregistersystem.controller;

import com.fasterxml.jackson.annotation.JsonView;
import me.plich.cashregistersystem.model.Device;
import me.plich.cashregistersystem.model.Location;
import me.plich.cashregistersystem.model.View;
import me.plich.cashregistersystem.service.DeviceService;
import me.plich.cashregistersystem.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    LocationService locationService;
    @Autowired
    DeviceService deviceService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addLocation(@RequestBody Location location, @RequestHeader Long customerID) {
        locationService.addLocation(location, customerID);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @JsonView(View.Public.class)
    public List<Location> getAllUserLocations() {
        return locationService.getAllUserLocation();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLocation(@PathVariable Long id) {
        locationService.deleteLocation(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Location getLocation(@PathVariable Long id) {
        return locationService.getLocation(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateLocation(@PathVariable Long id, @RequestBody Location location) {
        locationService.updateLocation(id, location);
    }

    @GetMapping("/advanced")
    @ResponseStatus(HttpStatus.OK)
    public List<Location> findAllByRsql(@RequestParam(value = "search") String search) {
        return locationService.findAllByRsql(search);
    }

    @GetMapping("/{id}/devices")
    @ResponseStatus(HttpStatus.OK)
    @JsonView(View.Public.class)
    public @ResponseBody List<Device> getAllLocationDevices(@PathVariable Long id) {
        return deviceService.getAllLocationDevices(id);
    }
}
