package me.plich.cashregistersystem.service;


import me.plich.cashregistersystem.model.Order;
import me.plich.cashregistersystem.repository.DeviceRepository;
import me.plich.cashregistersystem.repository.OrderRepository;
import me.plich.cashregistersystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    DeviceRepository deviceRepository;
    @Autowired
    UserRepository userRepository;

    public void addOrder(Order order, Long userID, Long deviceID) {
        order.setUser(userRepository.findById(userID).get());
        order.setDevice(deviceRepository.findById(deviceID).get());
        orderRepository.save(order);
    }

    public void deleteOrder(@PathVariable Long id) {
        orderRepository.deleteById(id);
    }

    public Order getOrder(@PathVariable Long id) {
        Order order = orderRepository.findById(id).get();
        return order;
    }

    public List<Order> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders;
    }

}
