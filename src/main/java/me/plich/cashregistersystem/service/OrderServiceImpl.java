package me.plich.cashregistersystem.service;


import me.plich.cashregistersystem.exception.CustomerNotFoundException;
import me.plich.cashregistersystem.exception.DeviceNotFoundException;
import me.plich.cashregistersystem.exception.OrderNotFoundException;
import me.plich.cashregistersystem.model.*;
import me.plich.cashregistersystem.repository.CustomerRepository;
import me.plich.cashregistersystem.repository.DeviceRepository;
import me.plich.cashregistersystem.repository.OrderRepository;
import me.plich.cashregistersystem.repository.UserRepository;
import me.plich.cashregistersystem.utils.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static me.plich.cashregistersystem.model.OrderType.*;
import static me.plich.cashregistersystem.utils.Utils.getNullPropertyNames;

@Service("orderService")
public class OrderServiceImpl implements IOrderService{


    private OrderRepository orderRepository;
    private DeviceRepository deviceRepository;
    private UserRepository userRepository;
    private CustomerRepository customerRepository;
    private IUserService userService;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, DeviceRepository deviceRepository, UserRepository userRepository, @Qualifier("userService") IUserService userService, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.deviceRepository = deviceRepository;
        this.userRepository = userRepository;
        this.userService = userService;
        this.customerRepository = customerRepository;
    }

    public Order addOrder(Long userId, Order order, Long deviceId) {
        User user = userRepository.getOne(userId);
        Device device = deviceRepository.findById(deviceId)
                .orElseThrow(() -> new DeviceNotFoundException(deviceId));
        if(Utils.checkUser(userId, device)) {
            order.setUser(user);
            order.setDevice(device);
            order.setCustomer(device.getCustomer());
            return orderRepository.save(order);
        } else {
            throw new DeviceNotFoundException(deviceId);
        }
    }



    public Order getOrder(Long userId, Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId));
        if(Utils.checkUser(userId, order)) {
            return order;
        } else {
            throw new OrderNotFoundException(orderId);
        }
    }


    public List<Order> findAllDevicesOrders(Long userId, Long deviceId) {
        Device device = deviceRepository.findById(deviceId)
                .orElseThrow(() -> new DeviceNotFoundException(deviceId));
        if(Utils.checkUser(userId, device)) {
            return device.getOrders();
        } else {
            throw new DeviceNotFoundException(deviceId);
        }
    }


    public List<Order> findAllCustomersOrders(Long userId, Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));
        if(Utils.checkUser(userId, customer)) {
            return customer.getOrders();
        } else {
            throw new CustomerNotFoundException(customerId);
        }
    }

    public List<Order> findAllUsersOrders(Long userId) {
        return userRepository.getOne(userId).getOrders();
    }

    public void deleteOrder(Long userId, Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId));
        if(Utils.checkUser(userId, order)) {
            orderRepository.deleteById(orderId);
        } else {
            throw new OrderNotFoundException(orderId);
        }
    }

    public Order updateOrder(Long userId, Long orderId, Order order) {
        Order orderToUpdate = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId));
        if(Utils.checkUser(userId, orderToUpdate)) {
            BeanUtils.copyProperties(order, orderToUpdate, getNullPropertyNames(order));
            return orderRepository.save(orderToUpdate);
        }
        else {
            throw new OrderNotFoundException(orderId);
        }
    }
}



