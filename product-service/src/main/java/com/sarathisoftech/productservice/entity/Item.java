package com.sarathisoftech.productservice.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
public class Item extends BaseEntity {
    @NotNull
    @Size(min = 2, max = 60, message = "Item Name can not be blank")
    private String name;
    @NotNull
    @Size(min = 2, max = 2147)
    private String description;
    @NotNull
    private double price;

}
