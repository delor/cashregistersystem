package me.plich.cashregistersystem.service;

import me.plich.cashregistersystem.model.Device;
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
public class DeviceSercive {

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

    public void addDevice(Device device, Long customerID, Long locationID) {
        device.setUser(userRepository.findById(userService.currentLoggedUserId()).get());
        device.setCustomer(customerRepository.findById(customerID).get());
        device.setLocation(locationRepository.findById(locationID).get());
        deviceRepository.save(device);
    }

    public void deleteDevice(@PathVariable Long id) {
        Device device = deviceRepository.getOne(id);
        if (device.getUser().getId() == userService.currentLoggedUserId()) {
            deviceRepository.deleteById(id);
        }
    }

    public Device getDevice(@PathVariable Long id) {
        Device device = deviceRepository.getOne(id);
        if(device.getUser().getId()==userService.currentLoggedUserId()) {
            return device;
        }
        return null;
    }

    public List<Device> getAllUserDevices() {
        List<Device> devices = deviceRepository.findByUser_id(userService.currentLoggedUserId());
        return devices;
    }

    public List<Device> getAllCustomerDevices(@PathVariable Long id) {
        List<Device> devices = deviceRepository.findByUser_idAndCustomer_id(userService.currentLoggedUserId(), id)
        return devices;
    }

    public void updateDevice(@PathVariable Long id, @RequestBody Device device) {
        Device deviceToUpdate = deviceRepository.getOne(id);
        if(deviceToUpdate.getUser().getId()==userService.currentLoggedUserId()) {
            if(device.getUniqueNumber() != null) {
                deviceToUpdate.setUniqueNumber(device.getUniqueNumber());
            }
            if(device.getSerialNumber() != null) {
                deviceToUpdate.setSerialNumber(device.getSerialNumber());
            }
            if(device.getProducer() != null) {
                deviceToUpdate.setProducer(device.getProducer());
            }
            if(device.getModel() != null) {
                deviceToUpdate.setModel(device.getModel());
            }
            if(device.getDateOfFiscalization() != null) {
                deviceToUpdate.setDateOfFiscalization(device.getDateOfFiscalization());
            }
            if(device.getDateOfDeRegistration() != null) {
                deviceToUpdate.setDateOfDeRegistration(device.getDateOfDeRegistration());
            }
            if(device.getEvidenceNumber() != null) {
                deviceToUpdate.setEvidenceNumber(device.getEvidenceNumber());
            }
            if(device.getReviewsFrequency() != null) {
                deviceToUpdate.setReviewsFrequency(device.getReviewsFrequency());
            }
            if(device.getLastReview() != null) {
                deviceToUpdate.setLastReview(device.getLastReview());
            }
            if(device.getPlannedReview() != null) {
                deviceToUpdate.setPlannedReview(device.getPlannedReview());
            }
            if(device.getDailyReports() != null) {
                deviceToUpdate.setDailyReports(device.getDailyReports());
            }
            if(device.getActive() != null) {
                deviceToUpdate.setActive(device.getActive());
            }
            if(device.getMobile() != null) {
                deviceToUpdate.setMobile(device.getMobile());
            }
            if(device.getReserve() != null) {
                deviceToUpdate.setReserve(device.getReserve());
            }
            if(device.getDescription() != null) {
                deviceToUpdate.setDescription(device.getDescription());
            }
            if(device.getLocation() != null) {
                deviceToUpdate.setLocation(device.getLocation());
            }
            deviceRepository.save(deviceToUpdate);

        }
    }
}
