package com.sarathisoftech.repository;

import com.sarathisoftech.entity.OrderedItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderedItemRepository extends JpaRepository<OrderedItem, Long> {


}
