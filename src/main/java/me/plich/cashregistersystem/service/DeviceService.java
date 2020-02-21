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
import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {


    DeviceRepository deviceRepository;
    UserRepository userRepository;
    CustomerRepository customerRepository;
    LocationRepository locationRepository;
    UserService userService;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository, UserRepository userRepository, CustomerRepository customerRepository, LocationRepository locationRepository, UserService userService) {
        this.deviceRepository = deviceRepository;
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
        this.locationRepository = locationRepository;
        this.userService = userService;
    }

    public void addDevice(Device device, Long customerID, Long locationID) {
        device.setUser(userRepository.findById(userService.currentLoggedUserId()).get());
        device.setCustomer(customerRepository.findById(customerID).get());
        device.setLocation(locationRepository.findById(locationID).get());
        deviceRepository.save(device);
    }

    public void deleteDevice(Long id) {
        Optional<Device> deviceOpt = deviceRepository.findById(id);
        if(deviceOpt.isPresent()) {
            Device device = deviceOpt.get();
            if (device.getUser().getId() == userService.currentLoggedUserId()) {
            deviceRepository.deleteById(id);
            }
        }
    }
    public Device getDevice(Long id) {
       try {
           Device device = deviceRepository.getOne(id);
           if(device.getUser().getId()==userService.currentLoggedUserId()) {
               return device;
           }
       } catch (EntityNotFoundException ex) {
           return null;
       }

        return null;
    }



    public List<Device> getAllUserDevices() {
        List<Device> devices = deviceRepository.findByUser_Id(userService.currentLoggedUserId());
        return devices;
    }

    public List<Device> getAllCustomerDevices(Long id) {
        List<Device> devices = deviceRepository.findByUser_IdAndCustomer_Id(userService.currentLoggedUserId(), id);
        return devices;
    }

    public List<Device> getAllLocationDevices(Long id) {
        List<Device> devices = deviceRepository.findByUser_IdAndLocation_Id(userService.currentLoggedUserId(), id);
        return devices;
    }

    public void updateDevice(@PathVariable Long id, @RequestBody Device device) {
        //do zaimplementowania analogicznie jak w przypadku encji user
         }



//    public void fiscalization(Long id) {
//
//    }

//    public void changeReviewDate(Long id) {
//        Device device = deviceRepository.findById(id).get();
//        if(device.getReviewsFrequency() == 24) {
//            device.setPlannedReview(LocalDate.now().plusYears(2));
//        } else {
//            device.setPlannedReview(LocalDate.now().plusYears(1));
//        }
//    }

//dorobić metodę zwracającą kasy do przeglądu w ciągu następnych x dni
}
