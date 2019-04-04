package com.sarathisoftech.shopclient.controllers;

import com.sarathisoftech.shopclient.model.Customer;
import com.sarathisoftech.shopclient.model.Product;
import com.sarathisoftech.shopclient.proxyclient.CustomerClient;
import com.sarathisoftech.shopclient.proxyclient.ProductClient;
import com.sarathisoftech.shopclient.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Controller
@Slf4j
public class ShopController implements WebMvcConfigurer {
    @Autowired
    private CustomerClient customerProxy;

    @Autowired
    private ProductClient productClient;


    @Autowired
    private OrderService orderService;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/register").setViewName("registration");
    }

    @GetMapping("/registration")
    public String registrationForm(Model model) {
        model.addAttribute(new Customer());
        return "registration";
    }

    @PostMapping("/registration")
    public String addCustomer(@ModelAttribute Customer customer,Model model) {
       log.info(">> "+customer.toString());
        orderService.addCustomer(customer);
        List<Product> products = orderService.getProductList();
        model.addAttribute("products",products);
        model.addAttribute("customerName",customer.getCustomerName());
        return "success";
    }

    @GetMapping("/customers")
    public String customerDetails(Model model) {


        List<Customer> customers = customerProxy.empList();
        model.addAttribute("customers", customers);

        return "customers";
    }


    @GetMapping("/products")
    public String productDetails(Model model) {
        List<Product> products = productClient.pList();
        model.addAttribute("products", products);
        return "product";
    }

    @GetMapping("/order")
    public String getOrderDetails(Model model) {

        /*OrderInfo order = orderService.submitOrder(10001, 102);
        model.addAttribute(order);*/
        return "orders";

    }
    @GetMapping("/submit")
    public void submit(){
        log.info("called");
    }

}
