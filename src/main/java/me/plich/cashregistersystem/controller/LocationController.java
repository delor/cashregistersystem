package me.plich.cashregistersystem.controller;

import com.fasterxml.jackson.annotation.JsonView;
import me.plich.cashregistersystem.model.Location;
import me.plich.cashregistersystem.model.View;
import me.plich.cashregistersystem.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    LocationService locationService;

    @PostMapping
    public void addLocation(@RequestBody Location location, @RequestHeader Long customerID) {
        locationService.addLocation(location, customerID);
    }

    @GetMapping
    @JsonView(View.Public.class)
    public List<Location> getAllLocations() {
        return locationService.getAllLocation();
    }

    @DeleteMapping("/location/{id}")
    public void deleteLocation(@PathVariable Long id) {
        locationService.deleteLocation(id);
    }

    @GetMapping("/location/{id}")
    public Location getLocation(@PathVariable Long id) {
        return locationService.getLocation(id);
    }
}
