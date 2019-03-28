package com.ts.labs.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;


@Data
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Student {
    @NotBlank(message = " name should not be blank!")
    private String name;
    @NotBlank(message = "surname should not be blank!")
    private String surname;
    @NotBlank(message = "phoneNumber should not be blank!")
    private String phoneNumber;
    @NotBlank(message = "address should not be blank!")
    private String address;
}
