package me.plich.cashregistersystem.controller;

import com.fasterxml.jackson.annotation.JsonView;
import me.plich.cashregistersystem.model.Location;
import me.plich.cashregistersystem.model.Order;
import me.plich.cashregistersystem.model.View;
import me.plich.cashregistersystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    public void addOrder(@RequestBody Order order, @RequestHeader Long deviceID) {
        orderService.addOrder(order, deviceID);
    }

    @GetMapping
    @JsonView(View.Public.class)
    public List<Order> getAllUserOrders() {
        return orderService.getAllUserOrders();
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }

    @PatchMapping("/{id}")
    public void updateOrder(@PathVariable Long id, @RequestBody Order order) {
        orderService.updateOrder(id, order);
    }

    @GetMapping("/advanced")
    public List<Order> findAllByRsql(@RequestParam(value = "search") String search) {
        return orderService.findAllByRsql(search);
    }
}
