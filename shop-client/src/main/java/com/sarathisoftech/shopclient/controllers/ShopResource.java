package com.sarathisoftech.shopclient.controllers;

import com.sarathisoftech.shopclient.model.Customer;
import com.sarathisoftech.shopclient.model.OrderInfo;
import com.sarathisoftech.shopclient.model.Product;
import com.sarathisoftech.shopclient.proxyclient.ProductClient;
import com.sarathisoftech.shopclient.proxyclient.CustomerClient;
import com.sarathisoftech.shopclient.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ShopResource {
    @Autowired
    private CustomerClient customerProxy;

    @Autowired
    private ProductClient productClient;
    @Autowired
    private OrderService service;

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerProxy.empList();
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productClient.pList();
    }

    @GetMapping("/customers/{id}")
    public Object findById(@PathVariable long id) {
        return customerProxy.getById(id);
    }

    @GetMapping("/hystrix")
    public Object hystrixTest() {


        return service.getCustomers();
    }

    @PostMapping("/products")
    public void addproduct(@RequestBody Product product) {
        productClient.addProduct(product);
    }

    @GetMapping("/orders")
    public OrderInfo submitOrders(
            @RequestParam double amount, @RequestParam long customerId, @RequestParam long productId
    ) {
        long id=1002;
        return service.submitOrder(id, amount, customerId, productId);
    }



}
