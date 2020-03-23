package me.plich.cashregistersystem.service;


import me.plich.cashregistersystem.exception.CustomerNotFoundException;
import me.plich.cashregistersystem.exception.DeviceNotFoundException;
import me.plich.cashregistersystem.exception.OrderNotFoundException;
import me.plich.cashregistersystem.exception.OrderTypeNotFoundException;
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
import java.util.List;
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
            switch (order.getOrderType()) {
                case fiscalization:
                    device.setDateOfFiscalization(order.getOrderDate());
                    device.setActive(true);
                    device.setPlannedReview(order.getOrderDate().plusMonths(device.getReviewsFrequency()));
                    device.setDailyReports(order.getDailyReportTo());
                    Order orderFiscalization = new Order();
                    order.setOrderType(order.getOrderType());
                    orderFiscalization.setOrderDate(order.getOrderDate());
                    orderFiscalization.setSeals(StateOfSeals.whole);
                    orderFiscalization.setGeneralCounterFrom(0);
                    orderFiscalization.setGeneralCounterTo(order.getGeneralCounterTo());
                    orderFiscalization.setDailyReportFrom(0);
                    orderFiscalization.setDailyReportTo(order.getDailyReportTo());
                    orderFiscalization.setResettingFramesFrom(0);
                    orderFiscalization.setResettingFramesTo(order.getResettingFramesTo());
                    orderFiscalization.setDevice(device);
                    orderRepository.save(orderFiscalization);
                    deviceRepository.save(device);
                    return orderFiscalization;
                case overview:
                    Order orderOverview = new Order();
                    orderOverview.setOrderType(order.getOrderType());
                    orderOverview.setOrderDate(order.getOrderDate());
                    orderOverview.setSeals(order.getSeals());
                    orderOverview.setGeneralCounterFrom(order.getGeneralCounterFrom());
                    orderOverview.setGeneralCounterTo(order.getGeneralCounterTo());
                    orderOverview.setDailyReportFrom(order.getDailyReportFrom());
                    orderOverview.setDailyReportTo(order.getDailyReportTo());
                    orderOverview.setResettingFramesFrom(order.getResettingFramesFrom());
                    orderOverview.setResettingFramesTo(order.getResettingFramesTo());
                    orderOverview.setDevice(device);
                    orderOverview.setUser(user);
                    orderOverview.setCustomer(device.getCustomer());
                    orderRepository.save(orderOverview);
                    device.setDailyReports(order.getDailyReportTo());
                    device.setPlannedReview(order.getOrderDate().plusMonths(device.getReviewsFrequency()));
                    device.setLastReview(order.getOrderDate());
                    deviceRepository.save(device);
                    return orderOverview;
                case repair:
                    Order orderRepair = new Order();
                    orderRepair.setOrderType(order.getOrderType());
                    orderRepair.setOrderDate(order.getOrderDate());
                    orderRepair.setSeals(order.getSeals());
                    orderRepair.setGeneralCounterFrom(order.getGeneralCounterFrom());
                    orderRepair.setGeneralCounterTo(order.getGeneralCounterTo());
                    orderRepair.setDailyReportFrom(order.getDailyReportFrom());
                    orderRepair.setDailyReportTo(order.getDailyReportTo());
                    orderRepair.setResettingFramesFrom(order.getResettingFramesFrom());
                    orderRepair.setResettingFramesTo(order.getResettingFramesTo());
                    orderRepair.setDevice(device);
                    orderRepair.setUser(user);
                    orderRepair.setCustomer(device.getCustomer());
                    orderRepository.save(orderRepair);
                    device.setDailyReports(order.getDailyReportTo());
                    deviceRepository.save(device);
                    return orderRepair;
                case deregistration:
                    Order orderDeregistration = new Order();
                    orderDeregistration.setOrderType(order.getOrderType());
                    orderDeregistration.setOrderDate(order.getOrderDate());
                    orderDeregistration.setSeals(order.getSeals());
                    orderDeregistration.setDevice(device);
                    orderDeregistration.setUser(user);
                    orderDeregistration.setCustomer(device.getCustomer());
                    orderRepository.save(orderDeregistration);
                    device.setActive(false);
                    device.setDateOfDeRegistration(order.getOrderDate());
                    return orderDeregistration;
            }
        } else {
            throw new DeviceNotFoundException(deviceId);
        }
        throw new OrderTypeNotFoundException(order.getOrderType().toString());
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



