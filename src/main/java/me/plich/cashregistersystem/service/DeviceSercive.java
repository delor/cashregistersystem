package me.plich.cashregistersystem.service;

import me.plich.cashregistersystem.model.Device;
import me.plich.cashregistersystem.repository.CustomerRepository;
import me.plich.cashregistersystem.repository.DeviceRepository;
import me.plich.cashregistersystem.repository.LocationRepository;
import me.plich.cashregistersystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class DeviceSercive {

    @Autowired
    DeviceRepository deviceRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    LocationRepository locationRepository;

    public void addDevice(Device device, Long userID, Long customerID, Long locationID) {
        device.setUser(userRepository.findById(userID).get());
        device.setCustomer(customerRepository.findById(customerID).get());
        device.setLocation(locationRepository.findById(locationID).get());
        deviceRepository.save(device);
    }

    public void deleteDevice(@PathVariable Long id) {
        deviceRepository.deleteById(id);
    }

    public Device getDevice(@PathVariable Long id) {
        Device device = deviceRepository.findById(id).get();
        return device;
    }

    public List<Device> getAllDevices() {
        List<Device> devices = deviceRepository.findAll();
        return devices;
    }
}
