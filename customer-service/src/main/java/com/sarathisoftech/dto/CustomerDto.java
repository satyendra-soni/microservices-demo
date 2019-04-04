package com.sarathisoftech.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String mobileNumber;

    private String portNo;
}
