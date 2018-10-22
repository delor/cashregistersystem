package me.plich.cashregistersystem.service;


import me.plich.cashregistersystem.model.Location;
import me.plich.cashregistersystem.repository.CustomerRepository;
import me.plich.cashregistersystem.repository.DeviceRepository;
import me.plich.cashregistersystem.repository.LocationRepository;
import me.plich.cashregistersystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    DeviceRepository deviceRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    UserService userService;

    public void addLocation(Location location, Long customerID) {
        location.setUser(userRepository.findById(userService.currentLoggedUserId()).get());
        location.setCustomer(customerRepository.findById(customerID).get());
        locationRepository.save(location);
    }

    public void deleteLocation(@PathVariable Long id) {
        locationRepository.deleteById(id);
    }

    public Location getLocation(@PathVariable Long id) {
        Location location = locationRepository.findById(id).get();
        return location;
    }

    public List<Location> getAllLocation() {
        List<Location> locations = locationRepository.findAll();
        return locations;
    }
}
