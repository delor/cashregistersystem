package me.plich.cashregistersystem.service;

import me.plich.cashregistersystem.exception.CustomerNotFoundException;
import me.plich.cashregistersystem.exception.DeviceNotFoundException;
import me.plich.cashregistersystem.exception.LocationNotFoundException;
import me.plich.cashregistersystem.exception.OrderNotFoundException;
import me.plich.cashregistersystem.model.Customer;
import me.plich.cashregistersystem.model.Device;
import me.plich.cashregistersystem.model.Location;
import me.plich.cashregistersystem.model.Order;
import me.plich.cashregistersystem.repository.*;
import me.plich.cashregistersystem.utils.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import static me.plich.cashregistersystem.utils.Utils.getNullPropertyNames;

@Service("deviceService")
public class DeviceServiceImpl implements IDeviceService {


    private DeviceRepository deviceRepository;
    private UserRepository userRepository;
    private CustomerRepository customerRepository;
    private LocationRepository locationRepository;
    private OrderRepository orderRepository;
    private IUserService userService;

    @Autowired
    public DeviceServiceImpl(DeviceRepository deviceRepository, UserRepository userRepository,OrderRepository orderRepository, CustomerRepository customerRepository, LocationRepository locationRepository, @Qualifier("userService") IUserService userService) {
        this.deviceRepository = deviceRepository;
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
        this.locationRepository = locationRepository;
        this.orderRepository = orderRepository;
        this.userService = userService;
    }

    public Device addDevice(Long userId, Device device, Long customerId) {
        device.setUser(userRepository.findById(userId).get());
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));
        if(Utils.checkUser(userId, customer)) {
            device.setCustomer(customer);
            return  deviceRepository.save(device);
        } else {
            throw new CustomerNotFoundException(customerId);
        }
    }

    public void deleteDevice(Long userId, Long deviceId) {
        Device device = deviceRepository.findById(deviceId)
                .orElseThrow(() -> new DeviceNotFoundException(deviceId));
        if(Utils.checkUser(userId, device)) {
            deviceRepository.deleteById(deviceId);
        }
        else {
            throw new DeviceNotFoundException(deviceId);
        }
    }

    public Device getDevice(Long userId, Long deviceId) {
        Device device = deviceRepository.findById(deviceId)
                .orElseThrow(() -> new DeviceNotFoundException(deviceId));
        if(Utils.checkUser(userId, device)) {
            return device;
        }
        else {
            throw new DeviceNotFoundException(deviceId);
        }
    }

    public List<Device> findAllUserDevices(Long userId) {
        return customerRepository.getOne(userId).getDevices();
    }

    public List<Device> findAllCustomerDevices(Long userId, Long customerId) {
    Customer customer = customerRepository.findById(customerId)
            .orElseThrow(() -> new CustomerNotFoundException(customerId));
        if(Utils.checkUser(userId, customer)) {
            return customer.getDevices();
        } else {
            throw new CustomerNotFoundException(customerId);
        }
    }

    public Device updateDevice(Long userId, Long deviceId, Device deviceFromDto) {
        Device deviceToUpdate = deviceRepository.findById(deviceId)
                .orElseThrow(() -> new DeviceNotFoundException(deviceId));
        if(Utils.checkUser(userId, deviceToUpdate)) {
            BeanUtils.copyProperties(deviceFromDto, deviceToUpdate, getNullPropertyNames(deviceFromDto));
            return deviceRepository.save(deviceToUpdate);
        }
        else {
            throw new DeviceNotFoundException(deviceId);
        }
    }


    public List<Device> findAllLocationsDevices(Long userId, Long locationId) {
        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new LocationNotFoundException(locationId));
        if(Utils.checkUser(userId, location)) {
            return location.getDevices();
        } else {
            throw new CustomerNotFoundException(locationId);
        }
    }


    public Device getOrdersDevice(Long userId, Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId));
        if(Utils.checkUser(userId, order)) {
            return order.getDevice();
        } else {
            throw new OrderNotFoundException(orderId);
        }
    }
}
