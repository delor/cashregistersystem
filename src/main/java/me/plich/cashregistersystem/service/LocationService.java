package me.plich.cashregistersystem.service;


import me.plich.cashregistersystem.model.Location;
import me.plich.cashregistersystem.repository.CustomerRepository;
import me.plich.cashregistersystem.repository.DeviceRepository;
import me.plich.cashregistersystem.repository.LocationRepository;
import me.plich.cashregistersystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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
        Location location = locationRepository.getOne(id);
        if(location.getUser().getId()==userService.currentLoggedUserId()) {
            locationRepository.deleteById(id);
        }
    }

    public Location getLocation(@PathVariable Long id) {
        Location location = locationRepository.getOne(id);
        if(location.getUser().getId()==userService.currentLoggedUserId()) {
            return location;
        }
        return null;
    }

    public List<Location> getAllCustomerLocations(@PathVariable Long userId) {
        List<Location> locations = locationRepository.findByUser_idAndCustomer_id(userService.currentLoggedUserId(), userId);
        return locations;
    }

    public List<Location> getAllUserLocation() {
        List<Location> locations = locationRepository.findByUser_id(userService.currentLoggedUserId());
        return locations;
    }

    public void updateLocation(@PathVariable Long id, @RequestBody Location location) {
        Location locationToUpdate = locationRepository.getOne(id);
        if(locationToUpdate.getUser().getId()==userService.currentLoggedUserId()) {
           if(location.getName() != null) {
               locationToUpdate.setName(location.getName());
           }
            if(location.getStreet() != null) {
                locationToUpdate.setStreet(location.getStreet());
            }
            if(location.getHouseNumber() !=  null) {
                locationToUpdate.setHouseNumber(location.getHouseNumber());
            }
            if(location.getFlatNumber() != null) {
                locationToUpdate.setFlatNumber(location.getFlatNumber());
            }
            if(location.getZipCode() != null) {
                locationToUpdate.setZipCode(location.getZipCode());
            }
            if(location.getPlace() != null) {
                locationToUpdate.setPlace(location.getPlace());
            }
            if(location.getVoivodeship() != null) {
                locationToUpdate.setVoivodeship(location.getVoivodeship());
            }
            if(location.getTelephone() != null) {
                locationToUpdate.setTelephone(location.getTelephone());
            }
            if(location.getEmail() != null) {
                locationToUpdate.setEmail(location.getEmail());
            }
            if(location.getDescription() != null) {
                locationToUpdate.setDescription(location.getDescription());
            }
            locationRepository.save(locationToUpdate);
        }
    }
}
