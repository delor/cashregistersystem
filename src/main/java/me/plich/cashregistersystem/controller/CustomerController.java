package me.plich.cashregistersystem.controller;

import com.fasterxml.jackson.annotation.JsonView;
import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import me.plich.cashregistersystem.config.rsql.CustomRsqlVisitor;
import me.plich.cashregistersystem.model.Customer;
import me.plich.cashregistersystem.model.View;
import me.plich.cashregistersystem.repository.CustomerRepository;
import me.plich.cashregistersystem.service.CustomerService;
import me.plich.cashregistersystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    UserService userService;

    @PostMapping
    public void addCustomer(@RequestBody Customer customer) {
        customerService.registerCustomer(customer);
    }
    @GetMapping
    @JsonView(View.Public.class)
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

    @JsonView(View.Public.class)
    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }

    @GetMapping("/advanced")
    public List<Customer> findAllByRsql(@RequestParam(value = "search") String search) {
        Node rootNode = new RSQLParser().parse(search);
        Specification<Customer> spec = rootNode.accept(new CustomRsqlVisitor<Customer>());
        List<Customer> customers =  customerRepository.findAll(spec);
        for (Customer rsqlCustomers : customers) {
            if (rsqlCustomers.getUser().getId() != userService.currentLoggedUserId()) {
                customers.remove(rsqlCustomers);
            }
        }
        return customers;
    }


}
