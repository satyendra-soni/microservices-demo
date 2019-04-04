package com.sarathisoftech.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data

@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {

    private long id;

    private String firstName;

    private String lastName;

    private String email;

    private String mobileNumber;
    @JsonIgnore
    private String password;

}
