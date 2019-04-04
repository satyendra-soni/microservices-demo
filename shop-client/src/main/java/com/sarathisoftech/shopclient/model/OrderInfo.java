package com.sarathisoftech.shopclient.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
//@Entity
public class OrderInfo {
//    @Id
//    @GeneratedValue
    private long id;

    private double amount;

    private LocalDateTime orderDate;
//    @ManyToOne
    private Customer customer;
//    @OneToMany
    private Product product;

    public OrderInfo(long id,double amount, LocalDateTime orderDate, Customer customer, Product product) {
        this.id = id;
        this.amount = amount;
        this.orderDate = orderDate;
        this.customer = customer;
        this.product = product;
    }
}