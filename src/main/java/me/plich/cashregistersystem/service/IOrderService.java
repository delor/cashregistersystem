package me.plich.cashregistersystem.service;

import me.plich.cashregistersystem.model.Order;
import java.util.List;

public interface IOrderService {
    Order addOrder(Long userId, Order order, Long deviceId);
    Order getOrder(Long userId, Long deviceId);
    List<Order> findAllDevicesOrders(Long userId, Long deviceId);
    List<Order> findAllUsersOrders(Long userId);
    void deleteOrder(Long userId, Long id);
    List<Order> findAllCustomersOrders(Long userId, Long customerId);
    Order updateOrder(Long userId, Long id, Order order);
}
