package com.sarathisoftech.productservice.service;

import com.sarathisoftech.productservice.entity.Item;
import com.sarathisoftech.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Optional<Item> productById(long id) {
        return repository.findById(id);
    }

    public List<Item> productList() {
        return repository.findAll();
    }

    public Item addItem(Item item) {

        repository.save(item);
        return item;

    }

    public void deleteById(Item item) {
        repository.deleteById(item.getId());
    }
}
