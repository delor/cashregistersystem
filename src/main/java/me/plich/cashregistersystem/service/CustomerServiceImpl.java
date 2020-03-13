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

@Service("customerService")
public class CustomerServiceImpl implements ICustomerService {

    private IUserService userService;
    private CustomerRepository customerRepository;
    private UserRepository userRepository;
    private DeviceRepository deviceRepository;
    private LocationRepository locationRepository;
    private OrderRepository orderRepository;


    @Autowired
    public CustomerServiceImpl(@Qualifier("userService") IUserService userService,
                               CustomerRepository customerRepository,
                               UserRepository userRepository,
                               DeviceRepository deviceRepository,
                               OrderRepository orderRepository,
                               LocationRepository locationRepository) {
        this.customerRepository = customerRepository;
        this.userRepository = userRepository;
        this.userService = userService;
        this.deviceRepository = deviceRepository;
        this.locationRepository = locationRepository;
        this.orderRepository = orderRepository;
    }

    public Customer addCustomer(Long userId, Customer customer) {
            customer.setUser(userRepository.findById(userId).get());
            return customerRepository.save(customer);
    }

    public void deleteCustomer(Long userId, Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));
        if(Utils.checkUser(userId, customer)) {
            customerRepository.deleteById(customerId);
        } else {
            throw new CustomerNotFoundException(customerId);
        }
    }

    public Customer getCustomer(Long userId, Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));
        if(Utils.checkUser(userId, customer)) {
            return customer;
        } else {
            throw new CustomerNotFoundException(customerId);
        }
    }

    public List<Customer> getAllCustomers(Long userId) {
        return userRepository.getOne(userId).getCustomers();
    }

    public Customer updateCustomer(Long userId, Long customerId, Customer customerFromDto) {
        Customer customerToUpdate = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));
        Long addressId = customerToUpdate.getAddress().getId();
        if(Utils.checkUser(userId, customerToUpdate)) {
            BeanUtils.copyProperties(customerFromDto, customerToUpdate, getNullPropertyNames(customerFromDto));
            customerToUpdate.getAddress().setId(addressId);
            return customerRepository.save(customerToUpdate);
        }
        else {
            throw new CustomerNotFoundException(customerId);
        }
    }

    public Customer getDevicesCustomer(Long userId, Long deviceId) {
        Device device = deviceRepository.findById(deviceId)
                .orElseThrow(() -> new DeviceNotFoundException(deviceId));
        if(Utils.checkUser(userId, device)) {
            return device.getCustomer();
        } else {
            throw new DeviceNotFoundException(deviceId);
        }
    }

    public Customer getLocationsCustomer(Long userId, Long locationId) {
        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new LocationNotFoundException(locationId));
        if(Utils.checkUser(userId, location)) {
            return location.getCustomer();
        } else {
            throw new LocationNotFoundException(locationId);
        }
    }


    public Customer getOrdersCustomer(Long userId, Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId));
        if(Utils.checkUser(userId, order)) {
            return order.getCustomer();
        } else {
            throw new OrderNotFoundException(orderId);
        }
    }
}


