package com.sarathisoftech.proxyclient;

import com.sarathisoftech.dto.Item;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("product-service")
@RibbonClient(name = "product-service")
public interface ItemClient {

    @GetMapping("/products")
    List<Item> itemList();

    @GetMapping("/products/{id}")
    Item findById(@PathVariable long id);

    @PostMapping("/products")
    void addProduct(@RequestBody Item product);
}
