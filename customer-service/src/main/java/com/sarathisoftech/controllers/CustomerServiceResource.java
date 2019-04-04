package com.sarathisoftech.controllers;

import com.sarathisoftech.dto.CustomerDto;
import com.sarathisoftech.entity.Customer;
import com.sarathisoftech.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.*;
import java.net.URI;
import java.util.List;
import java.util.Set;


@RestController
@RefreshScope
@RequestMapping("/api")
public class CustomerServiceResource {
    @Autowired
    private Environment env;
    @Autowired
    private CustomerService customerService;
    private Validator validator= Validation.buildDefaultValidatorFactory().getValidator();
//    @Autowired
//    CustomerResourceAssembler assembler;


    @GetMapping("/portTest/{id}")
    public CustomerDto home(@PathVariable long id) {
        // This is useful for debugging
        // When having multiple instance of gallery service running at different ports.
        // We load balance among them, and display which instance received the request.
        return customerService.portTest(id);//"Hello from Customer-Service running at portNo: " + env.getProperty("local.server.portNo");
    }

    @GetMapping("/customers")

    public List<Customer> getAllCustomers() {

        return customerService.findAll();


    }

    @GetMapping("/customers/{id}")
    public Customer findCustomerById(@PathVariable long id) {

        return customerService.findById(id);
    }


    @PostMapping("/customers")
    public ResponseEntity<Object> register(@Valid @RequestBody Customer customer) {


        Customer customer1 = customerService.addCustomer(customer);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(customer1.getId()).toUri();
        return ResponseEntity.created(uri).build();


    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/customerList")
    public void addCustomers(@RequestBody List<Customer> customers) {
        customerService.addCustomers(customers);
    }

    @DeleteMapping("/customers")
    public Customer deleteCustomer(@RequestBody Customer customer) {
        return customerService.deleteByAccountNo(customer.getId());

    }

    @PutMapping("/customers")
    public Customer update(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);

    }

}
