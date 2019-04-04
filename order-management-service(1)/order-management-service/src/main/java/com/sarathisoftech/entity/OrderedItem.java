package com.sarathisoftech.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class OrderedItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long ordereditemid;

    private Long productId;
    private int quantity;
    @JsonIgnore
    private long orderId;
   /* @ManyToOne
    private OrderInfo order;*/


}
