package com.sarathisoftech.shopclient.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sarathisoftech.shopclient.model.*;
import com.sarathisoftech.shopclient.proxyclient.ProductClient;
import com.sarathisoftech.shopclient.proxyclient.CustomerClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class OrderService {
    @Autowired
    private CustomerClient customerClient;

    @Autowired
    private ProductClient productClient;

    public OrderInfo submitOrder(long id,double amount, long customerId, long productId) {


        Customer customer = customerClient.getById(customerId);
        Product product = productClient.findById(productId);
        log.info("order Submitted " + new OrderInfo(id, amount, LocalDateTime.now(), customer, product));

        return new OrderInfo(id, amount, LocalDateTime.now(), customer, product);

    }

    public List<OrderInfo> orderInfoList(long id) {

        return null;

    }


    public void addCustomer(Customer customer) {
        log.info("Catching: " + customer.toString());
        customerClient.addCustomer(customer);

    }

    @HystrixCommand(fallbackMethod = "fallBack")
    public Product getCustomers() {

        return productClient.findById(101);
    }

    public Product fallBack() {
        Product product = new Product();
        return new Product(101, "Fallback Method",
                "It's The fallBack Method call");
    }

    public List<Product> getProductList() {
        return productClient.pList();
    }


}
