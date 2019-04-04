package com.sarathisoftech.repository;

import com.sarathisoftech.entity.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderInfoRepository extends JpaRepository<OrderInfo, Long> {
    List<OrderInfo> findAllByCustomerId(long customerId);
}
