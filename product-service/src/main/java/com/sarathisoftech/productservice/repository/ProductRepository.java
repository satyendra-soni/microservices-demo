package com.sarathisoftech.productservice.repository;

import com.sarathisoftech.productservice.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Item,Long> {

}
