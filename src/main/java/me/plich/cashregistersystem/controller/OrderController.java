package me.plich.cashregistersystem.controller;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.plich.cashregistersystem.model.Location;
import me.plich.cashregistersystem.model.Order;
import me.plich.cashregistersystem.model.View;
import me.plich.cashregistersystem.service.OrderPdfGenerator;
import me.plich.cashregistersystem.service.OrderService;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static me.plich.cashregistersystem.model.OrderType.fiscalization;

@RestController
@RequestMapping("/orders")
@Api(description = "Set of endpoints for Creating, Retrieving, Updating and Deleting of orders.")
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    OrderPdfGenerator orderPdfGenerator;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Creates new order")
    public void addOrder(@RequestBody Order order, @RequestHeader Long deviceID) throws IOException {
        orderService.addOrder(order,  deviceID);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @JsonView(View.Public.class)
    @ApiOperation("Returns list of all user orders")
    public List<Order> getAllUserOrders() {
        return orderService.getAllUserOrders();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Deletes order with a specific id from system")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Returns a order with a specific id")
    public Order getOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Updates the order with a specific id")
    public void updateOrder(@PathVariable Long id, @RequestBody Order order) {
        orderService.updateOrder(id, order);
    }

    @GetMapping("/advanced")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Returns order according to the criteria you want. Uses rsql.")
    public List<Order> findAllByRsql(@RequestParam(value = "search") String search) {
        return orderService.findAllByRsql(search);
    }

    @GetMapping("/pdf")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Returns a PDF document with order details for tax office")
    public PDDocument getOrderPDF(@RequestHeader Long customerID, @RequestHeader Long deviceID) throws IOException {
        return orderPdfGenerator.customerOrder(customerID, deviceID);
    }


}
