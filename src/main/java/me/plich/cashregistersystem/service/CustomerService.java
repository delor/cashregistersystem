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

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;



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
        if(customerToUpdate.getUser().getId()==userService.currentLoggedUserId()) {

            if (customer.getNip() != null) {
                customerToUpdate.setNip(customer.getNip());
            }
            if (customer.getName() != null) {
                customerToUpdate.setName(customer.getName());
            }
            if (customer.getStreet() != null) {
                customerToUpdate.setStreet(customer.getStreet());
            }
            if (customer.getHouseNumber() != null) {
                customerToUpdate.setHouseNumber(customer.getHouseNumber());
            }
            if (customer.getFlatNumber() != null) {
                customerToUpdate.setFlatNumber(customer.getFlatNumber());
            }
            if (customer.getZipCode() != null) {
                customerToUpdate.setZipCode(customer.getZipCode());
            }
            if (customer.getPlace() != null) {
                customerToUpdate.setPlace(customer.getPlace());
            }
            if (customer.getVoivodeship() != null) {
                customerToUpdate.setVoivodeship(customer.getVoivodeship());
            }
            if (customer.getTelephone() != null) {
                customerToUpdate.setTelephone(customer.getTelephone());
            }
            if (customer.getEmail() != null) {
                customerToUpdate.setEmail(customer.getEmail());
            }
            if (customer.getTaxOffice() != null) {
                customerToUpdate.setTaxOffice(customer.getTaxOffice());
            }
            if (customer.getDescription() != null) {
                customerToUpdate.setDescription(customer.getDescription());
            }

            customerRepository.save(customerToUpdate);
        }
    }
}

