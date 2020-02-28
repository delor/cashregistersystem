package me.plich.cashregistersystem.service;


import me.plich.cashregistersystem.model.Device;
import me.plich.cashregistersystem.model.Order;
import me.plich.cashregistersystem.repository.DeviceRepository;
import me.plich.cashregistersystem.repository.OrderRepository;
import me.plich.cashregistersystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static me.plich.cashregistersystem.model.OrderType.*;

@Service
public class OrderService {


    OrderRepository orderRepository;
    DeviceRepository deviceRepository;
    UserRepository userRepository;
    UserService userService;

    @Autowired
    public OrderService(OrderRepository orderRepository, DeviceRepository deviceRepository, UserRepository userRepository, UserService userService) {
        this.orderRepository = orderRepository;
        this.deviceRepository = deviceRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    public void addOrder(Order order, Long deviceID) throws IOException {
//        LocalDate today = order.getOrderDate();
//        Device device = deviceRepository.findById(deviceID).get();
//        order.setUser(userRepository.findById(userService.currentLoggedUserId()).get());
//        order.setDevice(device);
//        if(order.getOrderType() == fiscalization && device.getDateOfFiscalization() == null) {
//            device.setDateOfFiscalization(today);
//            device.setDailyReports(1);
//            device.setActive(true);
//            if (device.getReviewsFrequency() == 12) {
//                device.setPlannedReview(today.plusYears(1));
//            } else {
//                device.setPlannedReview(today.plusYears(2));
//            }
//        }
//        if(order.getOrderType() == overview) {
//            device.setLastReview(today);
//            if(device.getReviewsFrequency() == 12) {
//                device.setPlannedReview(today.plusYears(1));
//            } else{
//                device.setPlannedReview(today.plusYears(2));
//            }
//            device.setDailyReports(order.getDailyReportTo());
//        }
//        if(order.getOrderType() == repair && order.getDailyReportTo() != null) {
//                device.setDailyReports(order.getDailyReportTo());
//        }
//        if(order.getOrderType() == deregistration && device.getDateOfDeRegistration() == null){
//            device.setDateOfDeRegistration(today);
//            device.setActive(false);
//        }
        orderRepository.save(order);
    }

    public void deleteOrder(@PathVariable Long id) {
        Order order = orderRepository.getOne(id);
        if (order.getUser().getId() == userService.currentLoggedUserId()) {
            orderRepository.deleteById(id);
        }
    }

    public Order getOrder(@PathVariable Long id) {
        Order order = orderRepository.getOne(id);
        if(order.getUser().getId()==userService.currentLoggedUserId()) {
            return order;
        }
        return null;
    }

    public List<Order> getAllUserOrders() {
        return orderRepository.findByUser_id(userService.currentLoggedUserId());

    }

    public List<Order> getDeviceOrders(Long id) {
        return orderRepository.findByUser_idAndDevice_id(userService.currentLoggedUserId(), id);
    }

    public void updateOrder(@PathVariable Long id, @RequestBody Order order) {
        Order orderToUpdate = orderRepository.getOne(id);

            orderRepository.save(orderToUpdate);

        }
    }



