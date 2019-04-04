package com.sarathisoftech.shopclient.proxyclient;

import com.sarathisoftech.shopclient.model.Customer;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("customer-service")
@RibbonClient("customer-service")
public interface CustomerClient {
    @GetMapping("/customers")
    List<Customer> empList();

    @PostMapping("/customers")
    void addCustomer(@RequestBody Customer customer);

    @GetMapping("/customers/{id}")
    Customer getById(@PathVariable long id);

}
