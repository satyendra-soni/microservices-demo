package com.sarathisoftech.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class Item {

    private long id;

    private String name;

    private String description;

    private double price;



}