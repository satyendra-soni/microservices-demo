package com.sarathisoftech.shopclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Entity
public class Customer {
//    @Id
    private long id;

    private String customerName;

    private String email;
//    @OneToMany(mappedBy = "id")
    private List<OrderInfo> orderInfoList = new ArrayList<>();


}
