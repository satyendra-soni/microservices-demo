package com.sarathisoftech.shopclient.proxyclient;

import com.sarathisoftech.shopclient.model.Product;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "product-service")
@RibbonClient("product-service")
public interface ProductClient {
    @GetMapping("/products")
    List<Product> pList();

    @GetMapping("/products/{id}")
    Product findById(@PathVariable long id);

    @PostMapping("/products")
    void addProduct(@RequestBody Product product);
}
