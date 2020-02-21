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

    DeviceRepository deviceRepository;
    UserRepository userRepository;
    CustomerRepository customerRepository;
    LocationRepository locationRepository;
    UserService userService;

    @Autowired
    public LocationService(DeviceRepository deviceRepository, UserRepository userRepository, CustomerRepository customerRepository, LocationRepository locationRepository, UserService userService) {
        this.deviceRepository = deviceRepository;
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
        this.locationRepository = locationRepository;
        this.userService = userService;
    }

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

        //do zaimplementowania metoda na wzor tej z userService
    }

}
