package me.plich.cashregistersystem.service;


import me.plich.cashregistersystem.model.Customer;

import me.plich.cashregistersystem.repository.CustomerRepository;
import me.plich.cashregistersystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;



    public void registerCustomer(Customer customer) {
        customer.setUser(userRepository.findById(userService.currentLoggedUserId()).get());
        customerRepository.save(customer);
    }

    public void deleteCustomer(@PathVariable Long id) {
        Customer customer = customerRepository.getOne(id);
        if(customer.getUser().getId()==userService.currentLoggedUserId()) {
            customerRepository.deleteById(id);
        }

    }

    public Customer getCustomer(@PathVariable Long id) {
        Customer customer = customerRepository.findById(id).get();
        return customer;
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = customerRepository.findByUser_id(userService.currentLoggedUserId());
        return customers;
    }


}
