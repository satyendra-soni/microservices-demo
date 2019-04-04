package com.sarathisoftech.proxyclient;

import com.sarathisoftech.dto.Customer;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "customer-service")
@RibbonClient(name = "customer-service")
public interface CustomerClient {

    @GetMapping("/portTest/{id}")
    Object home(@PathVariable long id);

    @GetMapping("/customers")
    List<Customer> findAll();

    @PostMapping("/customers")
    void addCustomer(@RequestBody Customer customer);

    @GetMapping("/customers/{id}")
    Customer getById(@PathVariable long id);
}
