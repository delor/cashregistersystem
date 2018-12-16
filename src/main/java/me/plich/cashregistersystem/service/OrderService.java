package me.plich.cashregistersystem.service;


import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import me.plich.cashregistersystem.config.rsql.CustomRsqlVisitor;
import me.plich.cashregistersystem.model.Device;
import me.plich.cashregistersystem.model.Order;
import me.plich.cashregistersystem.repository.DeviceRepository;
import me.plich.cashregistersystem.repository.OrderRepository;
import me.plich.cashregistersystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static me.plich.cashregistersystem.model.OrderType.*;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    DeviceRepository deviceRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;


    public void addOrder(Order order, Long deviceID) throws IOException {
        LocalDate today = order.getOrderDate();
        Device device = deviceRepository.findById(deviceID).get();
        order.setUser(userRepository.findById(userService.currentLoggedUserId()).get());
        order.setDevice(device);
        if(order.getOrderType() == fiscalization && device.getDateOfFiscalization() == null) {
            device.setDateOfFiscalization(today);
            device.setDailyReports(1);
            device.setActive(true);
            if (device.getReviewsFrequency() == 12) {
                device.setPlannedReview(today.plusYears(1));
            } else {
                device.setPlannedReview(today.plusYears(2));
            }
        }
        if(order.getOrderType() == overview) {
            device.setLastReview(today);
            if(device.getReviewsFrequency() == 12) {
                device.setPlannedReview(today.plusYears(1));
            } else{
                device.setPlannedReview(today.plusYears(2));
            }
            device.setDailyReports(order.getDailyReportTo());
        }
        if(order.getOrderType() == repair) {
            if(order.getDailyReportTo() != null) {
                device.setDailyReports(order.getDailyReportTo());
            }
        }
        if(order.getOrderType() == deregistration && device.getDateOfDeRegistration() == null){
            device.setDateOfDeRegistration(today);
            device.setActive(false);
        }
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
        if(orderToUpdate.getUser().getId()==userService.currentLoggedUserId()) {
            if(order.getOrderType() != null) {
                orderToUpdate.setOrderType(order.getOrderType());
            }
            if(order.getOrderDate() != null) {
                orderToUpdate.setOrderDate(order.getOrderDate());
            }
            if(order.getSeals() != null) {
                orderToUpdate.setSeals(order.getSeals());
            }
            if(order.getGeneralCounterFrom() != null) {
                orderToUpdate.setGeneralCounterFrom(order.getGeneralCounterFrom());
            }
            if(order.getGeneralCounterTo() != null) {
                orderToUpdate.setGeneralCounterTo(order.getGeneralCounterTo());
            }
            if(order.getDailyReportFrom() != null) {
                orderToUpdate.setDailyReportFrom(order.getDailyReportFrom());
            }
            if(order.getDailyReportTo() != null) {
                orderToUpdate.setDailyReportTo(order.getDailyReportTo());
            }
            if(order.getResettingFramesFrom() != null) {
                orderToUpdate.setResettingFramesFrom(order.getResettingFramesFrom());
            }
            if(order.getResettingFramesTo() != null) {
                orderToUpdate.setResettingFramesTo(order.getResettingFramesTo());
            }
            if(order.getReceiptFrom() != null) {
                orderToUpdate.setReceiptFrom(order.getReceiptFrom());
            }
            if(order.getReceiptTo() != null) {
                orderToUpdate.setReceiptTo(order.getReceiptTo());
            }
//            if(order.getDescription() != null) {
//                orderToUpdate.setDescription(order.getDescription());
//            }
            orderRepository.save(orderToUpdate);

        }
    }

    public List<Order> findAllByRsql(@RequestParam(value = "search") String search) {
        Node rootNode = new RSQLParser().parse(search);
        Specification<Order> spec = rootNode.accept(new CustomRsqlVisitor<Order>());
        List<Order> orders =  orderRepository.findAll(spec);
        for (Order rsqlOrders : orders) {
            if (rsqlOrders.getUser().getId() != userService.currentLoggedUserId()) {
                orders.remove(rsqlOrders);
            }
        }
        return orders;
    }

}
