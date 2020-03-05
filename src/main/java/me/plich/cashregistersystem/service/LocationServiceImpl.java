package me.plich.cashregistersystem.service;


import me.plich.cashregistersystem.exception.CustomerNotFoundException;
import me.plich.cashregistersystem.exception.DeviceNotFoundException;
import me.plich.cashregistersystem.exception.LocationNotFoundException;
import me.plich.cashregistersystem.model.Customer;
import me.plich.cashregistersystem.model.Device;
import me.plich.cashregistersystem.model.Location;
import me.plich.cashregistersystem.repository.CustomerRepository;
import me.plich.cashregistersystem.repository.DeviceRepository;
import me.plich.cashregistersystem.repository.LocationRepository;
import me.plich.cashregistersystem.repository.UserRepository;
import me.plich.cashregistersystem.utils.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

import static me.plich.cashregistersystem.utils.Utils.getNullPropertyNames;

@Service("locationService")
public class LocationServiceImpl implements ILocationService {

    DeviceRepository deviceRepository;
    UserRepository userRepository;
    CustomerRepository customerRepository;
    LocationRepository locationRepository;
    IUserService userService;

    @Autowired
    public LocationServiceImpl(DeviceRepository deviceRepository,
                               UserRepository userRepository,
                               CustomerRepository customerRepository,
                               LocationRepository locationRepository,
                               @Qualifier("userService") IUserService userService) {
        this.deviceRepository = deviceRepository;
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
        this.locationRepository = locationRepository;
        this.userService = userService;
    }

    public Location addLocation(Long userId, Location location, Long customerId) {
        location.setUser(userRepository.findById(userService.getCurrentLoggedUserId()).get());
        location.setCustomer(customerRepository.findById(customerId).get());
        return locationRepository.save(location);
    }

    public void deleteLocation(Long userId, Long locationId) {
        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new LocationNotFoundException(locationId));
        if(Utils.checkUser(userId, location)) {
            locationRepository.deleteById(locationId);
        } else {
            throw new LocationNotFoundException(locationId);
        }
    }

    public Location getDevicesLocation(Long userId, Long deviceId) {
        Device device = deviceRepository.findById(deviceId)
                .orElseThrow(() -> new DeviceNotFoundException(deviceId));
        if(Utils.checkUser(userId, device)) {
            return device.getLocation();
        } else {
            throw new DeviceNotFoundException(deviceId);
        }
    }

    public Location getLocation(Long userId, Long locationId) {
        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new LocationNotFoundException(locationId));
        if(Utils.checkUser(userId, location)) {
            return location;
        } else {
            throw new CustomerNotFoundException(locationId);
        }

    }

    public List<Location> findAllCustomersLocations(Long userId, Long customerId) {
    Customer customer = customerRepository.findById(customerId)
            .orElseThrow(() -> new CustomerNotFoundException(customerId));
        if(Utils.checkUser(userId, customer)) {
            return customer.getLocations();
        } else {
            throw new CustomerNotFoundException(customerId);
        }
    }

    public List<Location> getAllLocations(Long userId) {
        return userRepository.getOne(userId).getLocations();
    }



    public Location updateLocation(Long userId, Long locationId, Location locationFromDto) {
        Location locationToUpdate = locationRepository.findById(locationId)
                .orElseThrow(() -> new LocationNotFoundException(locationId));
        if(Utils.checkUser(userId, locationToUpdate)) {
            BeanUtils.copyProperties(locationFromDto, locationToUpdate, getNullPropertyNames(locationFromDto));
            return locationRepository.save(locationToUpdate);
        }
        else {
            throw new CustomerNotFoundException(locationId);
        }

    }

}
