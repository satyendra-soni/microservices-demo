package com.sarathisoftech.shopclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Entity
public class Product {
//    @Id
    private long product_id;
    @NotNull
    @Size(min = 2, max = 50)
    private String product_name;
    @NotNull
    @Size(min = 2, max = 160)
    private String description;
//    @ManyToOne
    private OrderInfo orderInfo;

    public Product(long product_id, @NotNull @Size(min = 2, max = 50) String product_name, @NotNull @Size(min = 2, max = 160) String description) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.description = description;
    }
}
