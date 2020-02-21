package me.plich.cashregistersystem.service;



import me.plich.cashregistersystem.model.Customer;
import me.plich.cashregistersystem.repository.CustomerRepository;
import me.plich.cashregistersystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@Service
public class CustomerService {


    CustomerRepository customerRepository;
    UserRepository userRepository;
    UserService userService;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, UserRepository userRepository, UserService userService) {
        this.customerRepository = customerRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    public void addCustomer(Customer customer) {
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
        Customer customer = customerRepository.getOne(id);
        if(customer.getUser().getId()==userService.currentLoggedUserId()) {
            return customer;
        }
        return null;
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = customerRepository.findByUser_id(userService.currentLoggedUserId());
        return customers;
    }

    public void updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        Customer customerToUpdate = customerRepository.getOne(id);
        //do zaimplementowania analogicznie jak w przypadku encji user
            customerRepository.save(customerToUpdate);
        }
    }


