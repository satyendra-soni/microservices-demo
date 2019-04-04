package com.sarathisoftech.entity;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor

public class Customer extends BaseEntity {


    @NotNull(message = "firstName can't be empty")
    private String firstName;

    @NotNull(message = "lastName can't be empty")
    private String lastName;

    @Email
    private String email;

    private String mobileNumber;


    @NotBlank(message = "password field is necessary")
    private String password;

}
