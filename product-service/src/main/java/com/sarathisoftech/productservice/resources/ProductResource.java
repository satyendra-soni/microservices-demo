package com.sarathisoftech.productservice.resources;

import com.sarathisoftech.productservice.entity.Item;
import com.sarathisoftech.productservice.exceptions.ProductNotFoundException;
import com.sarathisoftech.productservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
@RefreshScope
public class ProductResource {

    @Autowired
    private Environment env;
    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public List<Item> products() {
        log.info("Item--List");
        return service.productList();

    }

    @GetMapping("/products/{id}")
    public Item productById(@PathVariable long id) {
        return service.productById(id)
                .orElseThrow(
                        ()->new ProductNotFoundException("No Customer Found With id " + id));
    }

    @PostMapping("/products")
    public ResponseEntity<Object> addProduct(@Valid @RequestBody Item item) {
        log.info("Item--Added");

        Item item1 = service.addItem(item);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(item1.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @DeleteMapping("/products")
    public void deleteById(@RequestBody Item item) {
        log.info("Item--deleted");

        service.deleteById(item);
    }


}
