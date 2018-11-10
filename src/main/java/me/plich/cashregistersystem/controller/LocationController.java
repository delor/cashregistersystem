package me.plich.cashregistersystem.controller;

import com.fasterxml.jackson.annotation.JsonView;
import me.plich.cashregistersystem.model.Location;
import me.plich.cashregistersystem.model.View;
import me.plich.cashregistersystem.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    LocationService locationService;

    @PostMapping
    public void addLocation(@RequestBody Location location, @RequestHeader Long customerID) {
        locationService.addLocation(location, customerID);
    }

    @GetMapping
    @JsonView(View.Public.class)
    public List<Location> getAllUserLocations() {
        return locationService.getAllUserLocation();
    }

    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable Long id) {
        locationService.deleteLocation(id);
    }

    @GetMapping("/{id}")
    public Location getLocation(@PathVariable Long id) {
        return locationService.getLocation(id);
    }

    @PatchMapping("/{id}")
    public void updateLocation(@PathVariable Long id, @RequestBody Location location) {
        locationService.updateLocation(id, location);
    }
}
