package me.plich.cashregistersystem.service;

import me.plich.cashregistersystem.command.devices.DeviceOperationExecutor;
import me.plich.cashregistersystem.command.devices.SetMobileDeviceCommand;
import me.plich.cashregistersystem.exception.*;
import me.plich.cashregistersystem.model.*;
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
    private ProducerRepository producerRepository;
    private ModelRepository modelRepository;
    private IUserService userService;

    @Autowired
    public DeviceServiceImpl(DeviceRepository deviceRepository, UserRepository userRepository,OrderRepository orderRepository, CustomerRepository customerRepository, LocationRepository locationRepository, @Qualifier("userService") IUserService userService, ModelRepository modelRepository, ProducerRepository producerRepository) {
        this.deviceRepository = deviceRepository;
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
        this.locationRepository = locationRepository;
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.producerRepository = producerRepository;
        this.modelRepository = modelRepository;
    }

    public Device addDevice(Long userId, Device device, Long customerId,Long producerId, Long modelId, Long locationId) {
        System.out.println("locationId service = "+locationId);
        device.setUser(userRepository.findById(userId).get());
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));
        Producer producer = producerRepository.findById(producerId)
                .orElseThrow(() -> new ProducerNotFoundException(producerId));
        Model model = modelRepository.findById(modelId)
                .orElseThrow(() -> new ModelNotFoundException(modelId));
        if(producerId != model.getProducer().getId()) {
            throw new ModelNotFoundException(modelId);
        }
        if(Utils.checkUser(userId, customer)) {
            device.setCustomer(customer);
            device.setProducer(producer);
            device.setModel(model);
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
        return userRepository.getOne(userId).getDevices();
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

    public void setMobile(Long userId, Long deviceId) {
        Device device = deviceRepository.findById(deviceId)
                .orElseThrow(() -> new DeviceNotFoundException(deviceId));
        if(Utils.checkUser(userId, device)) {
            DeviceOperationExecutor executor = new DeviceOperationExecutor(new SetMobileDeviceCommand(device));
            executor.executeOperations();
            deviceRepository.save(device);
        }
        else {
            throw new DeviceNotFoundException(deviceId);
        }
    }
}
