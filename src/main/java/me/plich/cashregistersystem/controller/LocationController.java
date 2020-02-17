package me.plich.cashregistersystem.controller;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(description = "Set of endpoints for Creating, Retrieving, Updating and Deleting of locations.")
public class LocationController {

    @Autowired
    LocationService locationService;
    @Autowired
    DeviceService deviceService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Creates new location")
    public void addLocation(@RequestBody Location location, @RequestHeader Long customerID) {
        locationService.addLocation(location, customerID);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @JsonView(View.Public.class)
    @ApiOperation("Returns list of all user locations")
    public List<Location> getAllUserLocations() {
        return locationService.getAllUserLocation();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Deletes location with a specific id from system")
    public void deleteLocation(@PathVariable Long id) {
        locationService.deleteLocation(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Returns a location with a specific id")
    public Location getLocation(@PathVariable Long id) {
        return locationService.getLocation(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Updates the location with a specific id")
    public void updateLocation(@PathVariable Long id, @RequestBody Location location) {
        locationService.updateLocation(id, location);
    }


    @GetMapping("/{id}/devices")
    @ResponseStatus(HttpStatus.OK)
    @JsonView(View.Public.class)
    @ApiOperation("Returns list of devices for location with a specific id")
    public @ResponseBody List<Device> getAllLocationDevices(@PathVariable Long id) {
        return deviceService.getAllLocationDevices(id);
    }
}
