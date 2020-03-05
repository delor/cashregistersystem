package me.plich.cashregistersystem.service;

import me.plich.cashregistersystem.model.Customer;

import java.util.List;

public interface ICustomerService {
    Customer addCustomer(Long userId, Customer customer);
    void deleteCustomer(Long userId, Long customerId);
    Customer getCustomer(Long userId, Long customerId);
    List<Customer> getAllCustomers(Long userId);
    Customer updateCustomer(Long userId, Long customerId, Customer customer);
    Customer getDevicesCustomer(Long userId, Long deviceId);
    Customer getLocationsCustomer(Long userId, Long locationId);
    Customer getOrdersCustomer(Long userId, Long orderId);
}
