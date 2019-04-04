package com.sarathisoftech.services;

import com.sarathisoftech.dto.CustomerDto;
import com.sarathisoftech.entity.Customer;
import com.sarathisoftech.exceptions.CustomerNotFoundException;
import com.sarathisoftech.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 *  Business logic class for managing the Customer information
 *
 * @author Satyendra Soni
 *
 */
@Service
@Slf4j
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    private Environment env;

    /*Testing Loadbalance through port No*/
    public CustomerDto portTest(long id) {
        Customer customer = customerRepository.getOne(id);
        CustomerDto dto = new CustomerDto();
        dto.setId(customer.getId());
        dto.setFirstName(customer.getFirstName());
        dto.setLastName(customer.getLastName());
        dto.setEmail(customer.getEmail());
        dto.setMobileNumber(customer.getMobileNumber());
        dto.setPortNo("Hello from Customer-Service running at port: " + env.getProperty("local.server.port"));
        return dto;


    }


    /*Retrieve Customer List*/

    public List<Customer> findAll() {

        log.info("Returning  all the customers");
        return customerRepository.findAll();
    }


    /*add a list of customers */
    public void addCustomers(List<Customer> list) {
        customerRepository.saveAll(list);

    }

    public Customer findById(long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("No Customer Found With id " + id));
    }


    public Customer addCustomer(Customer customer) {
        customerRepository.save(customer);
        return customer;

    }


    public Customer updateCustomer(Customer customer) {
        Customer byId = findById(customer.getId());
        if (byId == null)
            throw new CustomerNotFoundException("No Customer Found With id " + customer.getId());
        customerRepository.save(customer);
        return findById(customer.getId());
    }


    public Customer deleteByAccountNo(long account_no) {
        Customer customer = findById(account_no);
        if (customer != null)
            customerRepository.delete(customer);
        return customer;
    }
}
