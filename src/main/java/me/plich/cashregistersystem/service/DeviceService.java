package me.plich.cashregistersystem.service;

import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import me.plich.cashregistersystem.config.rsql.CustomRsqlVisitor;
import me.plich.cashregistersystem.model.Device;
import me.plich.cashregistersystem.repository.CustomerRepository;
import me.plich.cashregistersystem.repository.DeviceRepository;
import me.plich.cashregistersystem.repository.LocationRepository;
import me.plich.cashregistersystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {

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
        Optional<Device> deviceOpt = deviceRepository.findById(id);
        if(deviceOpt.isPresent()) {
            Device device = deviceOpt.get();
            if (device.getUser().getId() == userService.currentLoggedUserId()) {
            deviceRepository.deleteById(id);
            }
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
        Optional<Device> deviceToUpdateOpt = deviceRepository.findById(id);
        if (deviceToUpdateOpt.isPresent()) {
            Device deviceToUpdate = deviceToUpdateOpt.get();

            if (deviceToUpdate.getUser().getId() == userService.currentLoggedUserId()) {
                if (device.getUniqueNumber() != null) {
                    deviceToUpdate.setUniqueNumber(device.getUniqueNumber());
                }
                if (device.getSerialNumber() != null) {
                    deviceToUpdate.setSerialNumber(device.getSerialNumber());
                }
                if (device.getProducer() != null) {
                    deviceToUpdate.setProducer(device.getProducer());
                }
                if (device.getModel() != null) {
                    deviceToUpdate.setModel(device.getModel());
                }
                if (device.getDateOfFiscalization() != null) {
                    deviceToUpdate.setDateOfFiscalization(device.getDateOfFiscalization());
                }
                if (device.getDateOfDeRegistration() != null) {
                    deviceToUpdate.setDateOfDeRegistration(device.getDateOfDeRegistration());
                }
                if (device.getEvidenceNumber() != null) {
                    deviceToUpdate.setEvidenceNumber(device.getEvidenceNumber());
                }
                if (device.getReviewsFrequency() != null) {
                    deviceToUpdate.setReviewsFrequency(device.getReviewsFrequency());
                }
                if (device.getLastReview() != null) {
                    deviceToUpdate.setLastReview(device.getLastReview());
                }
                if (device.getPlannedReview() != null) {
                    deviceToUpdate.setPlannedReview(device.getPlannedReview());
                }
                if (device.getDailyReports() != null) {
                    deviceToUpdate.setDailyReports(device.getDailyReports());
                }
                if (device.getActive() != null) {
                    deviceToUpdate.setActive(device.getActive());
                }
                if (device.getMobile() != null) {
                    deviceToUpdate.setMobile(device.getMobile());
                }
                if (device.getReserve() != null) {
                    deviceToUpdate.setReserve(device.getReserve());
                }
                if (device.getDescription() != null) {
                    deviceToUpdate.setDescription(device.getDescription());
                }
                if (device.getLocation() != null) {
                    deviceToUpdate.setLocation(device.getLocation());
                }
                deviceRepository.save(deviceToUpdate);
            }
        }
    }
    public List<Device> findAllByRsql(@RequestParam(value = "search") String search) {
        Node rootNode = new RSQLParser().parse(search);
        Specification<Device> spec = rootNode.accept(new CustomRsqlVisitor<Device>());
        List<Device> devices =  deviceRepository.findAll(spec);
        for (Device rsqlDevices : devices) {
            if (rsqlDevices.getUser().getId() != userService.currentLoggedUserId()) {
                devices.remove(rsqlDevices);
            }
        }
        return devices;
    }

    public void fiscalization(Long id) {
        Device device = deviceRepository.findById(id).get();
        device.setActive(true);
        device.setDateOfFiscalization(LocalDate.now());
        changeReviewDate(id);


    }

    public void changeReviewDate(Long id) {
        Device device = deviceRepository.findById(id).get();
        if(device.getReviewsFrequency() == 24) {
            device.setPlannedReview(LocalDate.now().plusYears(2));
        } else {
            device.setPlannedReview(LocalDate.now().plusYears(1));
        }
    }

    public List<Device> devicesToReviewInNext7days() {
        LocalDate date = LocalDate.now();
        List<Device> devices = deviceRepository.findByUser_Id(userService.currentLoggedUserId());
        Iterator<Device> deviceIterator = devices.iterator();
        while(deviceIterator.hasNext()) {
            Device device = deviceIterator.next();
            if(device.getPlannedReview().isBefore(date) || device.getPlannedReview().isAfter(date.plusDays(7))) {
            deviceIterator.remove();
            }
        }
        return devices;
    }
}
