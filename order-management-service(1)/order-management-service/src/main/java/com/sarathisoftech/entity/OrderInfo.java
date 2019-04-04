package com.sarathisoftech.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Data
@Entity
@NoArgsConstructor
public class OrderInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long orderId;

    /* @Column(unique = true)
     private String orderId;
 */
    private Long customerId;

    private Date orderDate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderId", referencedColumnName = "orderId")
    private List<OrderedItem> orderedItemList = new ArrayList<>();


   /* @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderedItem> orderedItemList = new ArrayList<>();*/
}
