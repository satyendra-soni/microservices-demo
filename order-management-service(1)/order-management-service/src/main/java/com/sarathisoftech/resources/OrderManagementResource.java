package com.sarathisoftech.resources;

import com.sarathisoftech.dto.Customer;
import com.sarathisoftech.dto.Item;
import com.sarathisoftech.entity.OrderInfo;
import com.sarathisoftech.service.OrderManagementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RefreshScope
public class OrderManagementResource {
    @Autowired
    private Environment env;
    @Autowired
    private OrderManagementService service;

    //load balance check
    @GetMapping("/port")
    public String portTest() {
        return "Hello From Order-management-service Running On port: " + env.getProperty("local.server.port");
    }

    @GetMapping("/customers/port/{id}")
    public Object customerServicePort(@PathVariable long id) {
        return service.portTest(id);
    }

    //Test of feign client
    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return service.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable long id) {
        return service.getCustomerById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/orders")  ///customerId}/{{itemId}
    public void createOrder(@RequestParam long customerId, @RequestParam String itemId) {
        service.submitOrder(customerId, itemId);
    }

    @GetMapping("/customers/{id}/orders")
    public List<OrderInfo> itemsByCustomerId(@PathVariable long id) {
        return service.findOrdersByCustomerId(id);
    }

    @GetMapping("/orders/{id}/customers")
    public List<Item> getItems(@PathVariable long id){
        return service.ordersByCustomerId(id);
    }



}
